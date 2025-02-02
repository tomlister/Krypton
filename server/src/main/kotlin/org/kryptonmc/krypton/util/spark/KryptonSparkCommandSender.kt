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
package org.kryptonmc.krypton.util.spark

import me.lucko.spark.common.command.sender.AbstractCommandSender
import net.kyori.adventure.text.Component
import org.kryptonmc.api.adventure.toLegacySectionText
import org.kryptonmc.api.command.Sender
import org.kryptonmc.api.entity.player.Player
import java.util.UUID

class KryptonSparkCommandSender(sender: Sender) : AbstractCommandSender<Sender>(sender) {

    @Suppress("DEPRECATED_SMARTCAST")
    override fun getName(): String {
        if (delegate is Player) return delegate.profile.name
        return delegate.name.toLegacySectionText()
    }

    override fun getUniqueId(): UUID? {
        if (delegate is Player) return delegate.uuid
        return null
    }

    override fun sendMessage(message: Component) {
        delegate.sendMessage(message)
    }

    override fun hasPermission(permission: String): Boolean = delegate.hasPermission(permission)
}
