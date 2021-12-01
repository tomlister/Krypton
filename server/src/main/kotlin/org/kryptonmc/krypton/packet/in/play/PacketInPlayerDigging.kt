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
package org.kryptonmc.krypton.packet.`in`.play

import io.netty.buffer.ByteBuf
import org.kryptonmc.api.block.BlockFace
import org.kryptonmc.krypton.packet.Packet
import org.kryptonmc.krypton.util.asLong
import org.kryptonmc.krypton.util.decodeBlockPosition
import org.kryptonmc.krypton.util.readEnum
import org.kryptonmc.krypton.util.writeEnum
import org.spongepowered.math.vector.Vector3i

@JvmRecord
data class PacketInPlayerDigging(
    val status: Status,
    val location: Vector3i,
    val face: BlockFace
) : Packet {

    constructor(buf: ByteBuf) : this(buf.readEnum<Status>(), buf.readLong().decodeBlockPosition(), buf.readEnum())

    override fun write(buf: ByteBuf) {
        buf.writeEnum(status)
        buf.writeLong(location.asLong())
    }

    enum class Status {

        STARTED,
        CANCELLED,
        FINISHED,
        DROP_ITEM_STACK,
        DROP_ITEM,
        UPDATE_STATE,
        SWAP_ITEM_IN_HAND
    }
}
