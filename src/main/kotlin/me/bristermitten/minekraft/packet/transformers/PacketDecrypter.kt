package me.bristermitten.minekraft.packet.transformers

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageDecoder
import me.bristermitten.minekraft.extension.readAllAvailableBytes
import javax.crypto.Cipher

class PacketDecrypter(
        private val cipher: Cipher
) : MessageToMessageDecoder<ByteBuf>()
{

    override fun decode(ctx: ChannelHandlerContext, msg: ByteBuf, out: MutableList<Any>)
    {
        val data = msg.readAllAvailableBytes()
        val dataSize = data.size

        //Allocate a ByteBuf for decrypted output
        val decryptedBuffer = ctx.alloc().heapBuffer(cipher.getOutputSize(dataSize))

        //Write decrypted data into the ByteBuf
        val decryptedContent = decrypt(data, decryptedBuffer.array())

        decryptedBuffer.writerIndex(decryptedContent)
        out.add(decryptedBuffer)
    }

    fun decrypt(data: ByteArray, writeTo: ByteArray = data): Int
    {
        return cipher.update(data, 0, data.size, writeTo, 0)
    }
}