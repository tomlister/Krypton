package org.kryptonmc.krypton.command.commands

import net.kyori.adventure.text.Component
import org.kryptonmc.krypton.KryptonServer
import org.kryptonmc.krypton.api.command.Command
import org.kryptonmc.krypton.api.command.Sender

/**
 * Stop the server. That's literally all this does
 */
class StopCommand(private val server: KryptonServer) : Command("stop", "krypton.command.stop") {

    override fun execute(sender: Sender, args: List<String>) {
        sender.sendMessage(Component.text("Stopping server..."))
        server.stop()
    }
}
