/*
 * This file is part of the Krypton API, licensed under the MIT license.
 *
 * Copyright (C) 2021 KryptonMC and the contributors to the Krypton project.
 *
 * This project is licensed under the terms of the MIT license.
 * For more details, please reference the LICENSE file in the api top-level directory.
 */
package org.kryptonmc.api.registry

import net.kyori.adventure.key.Key
import org.kryptonmc.api.resource.ResourceKey
import org.kryptonmc.api.util.CataloguedBy

/**
 * A holder for registry entries.
 */
@Suppress("INAPPLICABLE_JVM_NAME")
@CataloguedBy(Registries::class)
public interface Registry<T : Any> : Map<ResourceKey<T>, T> {

    /**
     * The registry key for this registry.
     */
    @get:JvmName("key")
    public val key: ResourceKey<out Registry<T>>

    /**
     * The set of child keys.
     */
    @get:JvmName("keys")
    public val keySet: Set<Key>

    /**
     * Gets a value by its namespaced [key], or null if there is no value
     * associated with the given [key].
     *
     * @param key the key
     * @return the value, or null if not present
     */
    public operator fun get(key: Key): T?

    /**
     * Gets a value by its [id], or null if there is no value associated with
     * the given key.
     *
     * @param id the ID
     * @return the value, or null if not present
     */
    public operator fun get(id: Int): T?

    /**
     * Gets a namespaced [Key] by its [value], or null if there is no key
     * associated with the given [value].
     *
     * @param value the value
     * @return the key, or null if not present
     */
    public operator fun get(value: T): Key?

    /**
     * Registers a new value to this registry with the given registry [key]
     * and value.
     *
     * @param key the registry key
     * @param value the value
     * @return the value
     */
    public fun <V : T> register(key: ResourceKey<T>, value: V): V

    /**
     * Registers a new value to this registry with the given registry [key]
     * and value.
     *
     * @param id the ID of the entry in the registry
     * @param key the registry key
     * @param value the value
     * @return the value
     */
    public fun <V : T> register(id: Int, key: ResourceKey<T>, value: V): V

    /**
     * Registers a new value to this registry with the given registry [key]
     * and value.
     *
     * @param key the key
     * @param value the value
     */
    public fun <V : T> register(key: String, value: V): V = register(Key.key(key), value)

    /**
     * Registers a new value to this registry with the given registry [key]
     * and value.
     *
     * @param key the registry key
     * @param value the value
     * @return the value
     */
    public fun <V : T> register(key: Key, value: V): V

    /**
     * Registers a new value to this registry with the given registry [key]
     * and value.
     *
     * @param id the ID of the entry in the registry
     * @param key the key
     * @param value the value
     */
    public fun <V : T> register(id: Int, key: String, value: V): V = register(id, Key.key(key), value)

    /**
     * Registers a new value to this registry with the given registry [key]
     * and value.
     *
     * @param id the ID of the entry in the registry
     * @param key the key
     * @param value the value
     */
    public fun <V : T> register(id: Int, key: Key, value: V): V

    /**
     * Returns true if the given [key] is registered, false otherwise.
     *
     * @param key the key
     * @return true if registered, false otherwise
     */
    public operator fun contains(key: Key): Boolean

    /**
     * Gets the [ResourceKey] for the given [value], or null if there is no key
     * associated with the given [value].
     *
     * @param value the value
     * @return the resource key, or null if not present
     */
    public fun resourceKey(value: T): ResourceKey<T>?

    /**
     * Gets the ID for the given [value], or returns -1 if the given [value] is
     * not registered.
     *
     * @param value the value
     * @return the ID, or -1 if the [value] is not registered
     */
    public fun idOf(value: T): Int
}
