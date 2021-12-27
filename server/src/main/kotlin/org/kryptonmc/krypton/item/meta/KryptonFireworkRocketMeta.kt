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
package org.kryptonmc.krypton.item.meta

import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import net.kyori.adventure.text.Component
import org.kryptonmc.api.block.Block
import org.kryptonmc.api.item.data.FireworkEffect
import org.kryptonmc.api.item.meta.FireworkRocketMeta
import org.kryptonmc.krypton.item.data.KryptonFireworkEffect
import org.kryptonmc.krypton.item.data.save
import org.kryptonmc.krypton.util.mapPersistentList
import org.kryptonmc.nbt.CompoundTag

class KryptonFireworkRocketMeta(
    damage: Int,
    isUnbreakable: Boolean,
    customModelData: Int,
    name: Component?,
    lore: PersistentList<Component>,
    hideFlags: Int,
    canDestroy: ImmutableSet<Block>,
    canPlaceOn: ImmutableSet<Block>,
    override val effects: PersistentList<FireworkEffect>,
    override val flightDuration: Int
) : AbstractItemMeta<KryptonFireworkRocketMeta>(damage, isUnbreakable, customModelData, name, lore, hideFlags, canDestroy, canPlaceOn),
    FireworkRocketMeta {

    constructor(tag: CompoundTag) : this(
        tag.getInt("Damage"),
        tag.getBoolean("Unbreakable"),
        tag.getInt("CustomModelData"),
        tag.getName(),
        tag.getLore(),
        tag.getInt("HideFlags"),
        tag.getBlocks("CanDestroy"),
        tag.getBlocks("CanPlaceOn"),
        tag.getCompound("Fireworks").getList("Explosions", CompoundTag.ID).mapPersistentList { KryptonFireworkEffect(it as CompoundTag) },
        tag.getCompound("Fireworks").getByte("Flight").toInt()
    )

    override fun copy(
        damage: Int,
        isUnbreakable: Boolean,
        customModelData: Int,
        name: Component?,
        lore: PersistentList<Component>,
        hideFlags: Int,
        canDestroy: ImmutableSet<Block>,
        canPlaceOn: ImmutableSet<Block>
    ): KryptonFireworkRocketMeta = copy(damage, isUnbreakable, customModelData, name, lore, hideFlags, canDestroy, canPlaceOn)

    override fun saveData(): CompoundTag.Builder = super.saveData().apply {
        compound("Fireworks") {
            list("Explosions", CompoundTag.ID, effects.map(FireworkEffect::save))
            byte("Flight", flightDuration.toByte())
        }
    }

    override fun withEffects(effects: List<FireworkEffect>): KryptonFireworkRocketMeta = copy(effects = effects.toPersistentList())

    override fun addEffect(effect: FireworkEffect): KryptonFireworkRocketMeta = withEffects(effects.add(effect))

    override fun removeEffect(index: Int): KryptonFireworkRocketMeta = withEffects(effects.removeAt(index))

    override fun removeEffect(effect: FireworkEffect): KryptonFireworkRocketMeta = withEffects(effects.remove(effect))

    override fun withFlightDuration(duration: Int): KryptonFireworkRocketMeta = copy(flightDuration = duration)

    override fun toBuilder(): FireworkRocketMeta.Builder = Builder(this)

    private fun copy(
        damage: Int = this.damage,
        isUnbreakable: Boolean = this.isUnbreakable,
        customModelData: Int = this.customModelData,
        name: Component? = this.name,
        lore: PersistentList<Component> = this.lore,
        hideFlags: Int = this.hideFlags,
        canDestroy: ImmutableSet<Block> = this.canDestroy,
        canPlaceOn: ImmutableSet<Block> = this.canPlaceOn,
        effects: PersistentList<FireworkEffect> = this.effects,
        flightDuration: Int = this.flightDuration
    ): KryptonFireworkRocketMeta = KryptonFireworkRocketMeta(
        damage,
        isUnbreakable,
        customModelData,
        name,
        lore,
        hideFlags,
        canDestroy,
        canPlaceOn,
        effects,
        flightDuration
    )

    class Builder() : KryptonItemMetaBuilder<FireworkRocketMeta.Builder, FireworkRocketMeta>(), FireworkRocketMeta.Builder {

        private val effects = persistentListOf<FireworkEffect>().builder()
        private var flightDuration = 0

        constructor(meta: FireworkRocketMeta) : this() {
            copyFrom(meta)
            effects.addAll(meta.effects)
            flightDuration = meta.flightDuration
        }

        override fun effects(effects: Iterable<FireworkEffect>): FireworkRocketMeta.Builder = apply {
            this.effects.clear()
            this.effects.addAll(effects)
        }

        override fun addEffect(effect: FireworkEffect): FireworkRocketMeta.Builder = apply { effects.add(effect) }

        override fun flightDuration(duration: Int): FireworkRocketMeta.Builder = apply { flightDuration = duration }

        override fun build(): KryptonFireworkRocketMeta = KryptonFireworkRocketMeta(
            damage,
            unbreakable,
            customModelData,
            name,
            lore.build(),
            hideFlags,
            canDestroy.build(),
            canPlaceOn.build(),
            effects.build(),
            flightDuration
        )
    }
}