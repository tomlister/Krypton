package org.kryptonmc.krypton.packet

import org.kryptonmc.krypton.packet.`in`.*
import org.kryptonmc.krypton.packet.`in`.PacketInPlayerMovement.*
import org.kryptonmc.krypton.packet.`in`.handshake.PacketInHandshake
import org.kryptonmc.krypton.packet.`in`.login.PacketInEncryptionResponse
import org.kryptonmc.krypton.packet.`in`.status.PacketInPing
import org.kryptonmc.krypton.packet.`in`.status.PacketInStatusRequest
import org.kryptonmc.krypton.packet.state.PacketState

object PacketLoader {

    fun loadAll() {
        // HANDSHAKE
        PacketState.HANDSHAKE.registerPacketType(0, ::PacketInHandshake)

        // STATUS
        PacketState.STATUS.registerPacketType(0, ::PacketInStatusRequest)
        PacketState.STATUS.registerPacketType(1, ::PacketInPing)

        // LOGIN
        PacketState.LOGIN.registerPacketType(0x0, ::PacketInLoginStart)
        PacketState.LOGIN.registerPacketType(0x1, ::PacketInEncryptionResponse)

        // PLAY
        PacketState.PLAY.registerPacketType(0x03, ::PacketInChat)
        PacketState.PLAY.registerPacketType(0x05, ::PacketInClientSettings)
        PacketState.PLAY.registerPacketType(0x10, ::PacketInKeepAlive)
        PacketState.PLAY.registerPacketType(0x12, ::PacketInPlayerPosition)
        PacketState.PLAY.registerPacketType(0x13, ::PacketInPlayerPositionAndRotation)
        PacketState.PLAY.registerPacketType(0x14, ::PacketInPlayerRotation)
        PacketState.PLAY.registerPacketType(0x0B, ::PacketInPluginMessage)
    }
}