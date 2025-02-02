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
package org.kryptonmc.krypton.packet.out.play

import io.netty.buffer.ByteBuf
import org.kryptonmc.krypton.entity.player.KryptonPlayer
import org.kryptonmc.krypton.packet.EntityPacket
import org.kryptonmc.krypton.util.writeAngle
import org.kryptonmc.krypton.util.writeUUID
import org.kryptonmc.krypton.util.writeVarInt
import java.util.UUID

/**
 * Spawn a player for the client.
 */
@JvmRecord
data class PacketOutSpawnPlayer(
    override val entityId: Int,
    val uuid: UUID,
    val x: Double,
    val y: Double,
    val z: Double,
    val yaw: Float,
    val pitch: Float
) : EntityPacket {

    constructor(player: KryptonPlayer) : this(
        player.id,
        player.uuid,
        player.location.x(),
        player.location.y(),
        player.location.z(),
        player.rotation.x(),
        player.rotation.y()
    )

    override fun write(buf: ByteBuf) {
        buf.writeVarInt(entityId)
        buf.writeUUID(uuid)
        buf.writeDouble(x)
        buf.writeDouble(y)
        buf.writeDouble(z)
        buf.writeAngle(yaw)
        buf.writeAngle(pitch)
    }
}
