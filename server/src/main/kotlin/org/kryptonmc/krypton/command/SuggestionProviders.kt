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
package org.kryptonmc.krypton.command

import com.mojang.brigadier.context.CommandContext
import com.mojang.brigadier.suggestion.SuggestionProvider
import com.mojang.brigadier.suggestion.Suggestions
import com.mojang.brigadier.suggestion.SuggestionsBuilder
import net.kyori.adventure.key.Key
import net.kyori.adventure.key.Key.key
import net.kyori.adventure.text.Component.translatable
import org.kryptonmc.api.adventure.toMessage
import org.kryptonmc.api.command.Sender
import org.kryptonmc.api.entity.EntityType
import org.kryptonmc.krypton.registry.InternalRegistries
import java.util.concurrent.CompletableFuture

object SuggestionProviders {

    private val PROVIDERS_BY_NAME = mutableMapOf<Key, SuggestionProvider<Sender>>()
    private val DEFAULT_NAME = key("ask_server")

    @JvmField
    val SUMMONABLE_ENTITIES: SuggestionProvider<Sender> = register(key("summonable_entities")) { _, builder ->
        InternalRegistries.ENTITY_TYPE.values.asSequence()
            .filter { it.isSummonable }
            .suggestKey(builder, EntityType<*>::key) {
                val key = InternalRegistries.ENTITY_TYPE[it]
                translatable("entity.${key.namespace()}.${key.value().replace("/", ".")}").toMessage()
            }
    }

    @JvmStatic
    fun register(key: Key, provider: SuggestionProvider<Sender>): SuggestionProvider<Sender> {
        require(key !in PROVIDERS_BY_NAME) {
            "A command suggestion provider is already registered with the given key $key!"
        }
        PROVIDERS_BY_NAME[key] = provider
        return Wrapper(key, provider)
    }

    @JvmStatic
    fun name(provider: SuggestionProvider<Sender>): Key {
        if (provider is Wrapper) return provider.name
        return DEFAULT_NAME
    }

    @JvmRecord
    private data class Wrapper(
        val name: Key,
        private val delegate: SuggestionProvider<Sender>
    ) : SuggestionProvider<Sender> {

        override fun getSuggestions(
            context: CommandContext<Sender>?,
            builder: SuggestionsBuilder?
        ): CompletableFuture<Suggestions> = delegate.getSuggestions(context, builder)
    }
}
