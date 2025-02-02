/*
 * This file is part of the Krypton project, licensed under the GNU General Public License v3.0
 *
 * Copyright (C) 2021 KryptonMC and the contributors of the Krypton project
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.kryptonmc.krypton.commands

import com.mojang.brigadier.Command
import com.mojang.brigadier.CommandDispatcher
import net.kyori.adventure.text.Component
import org.kryptonmc.api.command.Sender
import org.kryptonmc.krypton.command.InternalCommand
import org.kryptonmc.krypton.command.argument
import org.kryptonmc.krypton.command.argument.argument
import org.kryptonmc.krypton.command.arguments.entities.EntityArgument
import org.kryptonmc.krypton.command.arguments.entities.entityArgument
import org.kryptonmc.krypton.command.arguments.item.ItemStackPredicate
import org.kryptonmc.krypton.command.arguments.item.ItemStackPredicateArgument
import org.kryptonmc.krypton.command.literal
import org.kryptonmc.krypton.command.permission
import org.kryptonmc.krypton.entity.player.KryptonPlayer
import org.kryptonmc.krypton.item.EmptyItemStack
import org.kryptonmc.krypton.item.KryptonItemStack
import org.kryptonmc.krypton.packet.out.play.PacketOutWindowItems

object ClearCommand : InternalCommand {

    override fun register(dispatcher: CommandDispatcher<Sender>) {
        dispatcher.register(literal("clear") {
            permission(KryptonPermission.CLEAR)
            executes {
                if (it.source !is KryptonPlayer) return@executes 0
                clear(listOf(it.source as KryptonPlayer), it.source)
                Command.SINGLE_SUCCESS
            }
            argument("targets", EntityArgument.players()) {
                executes {
                    clear(it.entityArgument("targets").players(it.source), it.source)
                    Command.SINGLE_SUCCESS
                }
                argument("item", ItemStackPredicateArgument) {
                    executes {
                        clear(it.entityArgument("targets").players(it.source), it.source, it.argument("item"))
                        Command.SINGLE_SUCCESS
                    }
                }
            }
        })
    }

    //-1 means that everything should be cleared (there is no limit)
    @JvmStatic
    private fun clear(
        targets: List<KryptonPlayer>,
        sender: Sender,
        predicate: ItemStackPredicate = ItemStackPredicate { true },
        maxCount: Int = -1
    ) {
        val amount = if (maxCount == -1) "all" else maxCount.toString()
        if (targets.size == 1) {
            val target = targets[0]
            clear(target, predicate, maxCount)
            sender.sendMessage(Component.translatable("commands.clear.success.single", Component.text(amount), target.displayName))
            target.session.send(PacketOutWindowItems(target.inventory, target.inventory.mainHand))
        } else {
            targets.forEach { target ->
                target.inventory.forEachIndexed { index, item -> if (predicate(item)) target.inventory[index] = EmptyItemStack }
                target.session.send(PacketOutWindowItems(target.inventory, target.inventory.mainHand))
            }
            sender.sendMessage(Component.translatable(
                "commands.clear.success.multiple",
                Component.text(amount),
                Component.text(targets.size.toString())
            ))
        }
    }

    @JvmStatic
    private fun clear(target: KryptonPlayer, predicate: ItemStackPredicate, maxCount: Int) {
        val inventory = target.inventory
        var remaining = maxCount

        // Clear inventory items
        remaining = clearList(predicate, remaining, inventory.items) { inventory.items[it] = EmptyItemStack }
        if (remaining == 0) return

        // Clear armor items
        remaining = clearList(predicate, remaining, inventory.armor) { inventory.armor[it] = EmptyItemStack }
        if (remaining == 0) return

        // Clear crafting items
        remaining = clearList(predicate, remaining, inventory.crafting) { inventory.crafting[it] = EmptyItemStack }
        if (remaining == 0) return

        // Clear offhand
        clearItem(predicate, remaining, inventory.offHand) { inventory.offHand = EmptyItemStack }
    }

    @JvmStatic
    private fun clearList(
        predicate: ItemStackPredicate,
        originalRemaining: Int,
        items: MutableList<KryptonItemStack>,
        removeItem: (Int) -> Unit
    ) : Int {
        var remaining = originalRemaining
        items.forEachIndexed { index, item ->
            if (!predicate(item)) return@forEachIndexed
            when {
                remaining == -1 -> removeItem(index)
                remaining > item.amount -> {
                    removeItem(index)
                    remaining -= item.amount
                }
                else -> {
                    item.amount -= remaining
                    remaining = 0
                    return remaining
                }
            }
        }
        return remaining
    }

    @JvmStatic
    private fun clearItem(
        predicate: ItemStackPredicate,
        remaining: Int,
        item: KryptonItemStack,
        removeItem: () -> Unit
    ) {
        if (!predicate(item)) return
        when {
            remaining == -1 -> removeItem()
            remaining > item.amount -> removeItem()
            else -> item.amount -= remaining
        }
    }
}
