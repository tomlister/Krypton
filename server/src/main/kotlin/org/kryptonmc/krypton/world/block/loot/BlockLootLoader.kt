package org.kryptonmc.krypton.world.block.loot;

import com.google.common.collect.ImmutableSet
import com.google.gson.JsonObject
import net.kyori.adventure.key.Key
import org.kryptonmc.krypton.KryptonPlatform
import org.kryptonmc.krypton.registry.InternalRegistries
import org.kryptonmc.krypton.registry.KryptonRegistryManager
import org.kryptonmc.krypton.util.KryptonDataLoader

object BlockLootLoader : KryptonDataLoader("loot_tables/${KryptonPlatform.minecraftVersionPath}_block_loot_tables")  {

    override fun load(data: JsonObject) {
        data.entrySet().forEach { (key, value) ->
            val namespacedKey = Key.key(key)
            value as JsonObject

            val pools = Array<>()

            value.remove("pools").asJsonArray.forEach {
                it.asJsonObject[]
            }
            if (InternalRegistries.BLOCK_LOOT.contains(namespacedKey)) return@forEach
            KryptonRegistryManager.register(InternalRegistries.BLOCK_LOOT, )
        }
    }

    class BlockLootPool(
        val conditions: [],
        val functions,
        val rolls,
        val bonusRolls,
        val entries,
    ) {
    }
}
