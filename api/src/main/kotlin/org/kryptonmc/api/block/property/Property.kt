/*
 * This file is part of the Krypton API, licensed under the MIT license.
 *
 * Copyright (C) 2021 KryptonMC and the contributors to the Krypton project.
 *
 * This project is licensed under the terms of the MIT license.
 * For more details, please reference the LICENSE file in the api top-level directory.
 */
package org.kryptonmc.api.block.property

import org.jetbrains.annotations.ApiStatus
import org.kryptonmc.api.util.FACTORY_PROVIDER
import org.kryptonmc.api.util.StringSerializable
import org.kryptonmc.api.util.provide

/**
 * Represents a property key.
 */
interface Property<T : Comparable<T>> {

    /**
     * The name of the property key.
     */
    val name: String

    /**
     * The set of values this property key allows.
     */
    val values: Set<T>

    /**
     * The type of this property key.
     */
    val type: Class<T>

    /**
     * Parses the given string [value] to a value this property key allows,
     * or returns null if the value does not parse to [T].
     *
     * @param value the string value
     * @return the parsed value, or null if the value cannot be parsed to [T]
     */
    fun fromString(value: String): T?

    /**
     * Converts the given [value] to its string equivalent.
     *
     * @param value the value
     * @return the string equivalent of the value
     */
    fun toString(value: T): String

    @Suppress("UndocumentedPublicClass", "UndocumentedPublicFunction")
    @ApiStatus.Internal
    interface Factory {

        fun forBoolean(name: String): Property<Boolean>

        fun forInt(name: String, values: Set<Int>): Property<Int>

        fun <E> forEnum(name: String, type: Class<E>, values: Set<E>): Property<E> where E : Enum<E>, E : StringSerializable
    }

    companion object {

        /**
         * Creates a new boolean property with the given [name].
         *
         * The accepted values for this property are always `true` and `false.
         *
         * @param name the name
         * @return a new boolean property
         */
        @JvmStatic
        fun forBoolean(name: String) = FACTORY.forBoolean(name)

        /**
         * Creates a new integer property with the given [name] and the given
         * set of accepted [values].
         *
         * @param name the name
         * @param values the set of accepted values
         * @return a new integer property
         */
        @JvmStatic
        fun forInt(name: String, values: Set<Int>) = FACTORY.forInt(name, values)

        /**
         * Creates a new integer property with the given [name] and the given
         * vararg array of accepted [values].
         *
         * @param name the name
         * @param values the array of accepted values
         * @return a new integer property
         */
        @JvmStatic
        fun forInt(name: String, vararg values: Int) = forInt(name, values.toSet())

        /**
         * Creates a new integer property with the given [name] and the given
         * [range] of accepted values.
         *
         * @param name the name
         * @param range the range of accepted values
         * @return a new integer property
         */
        @JvmStatic
        fun forInt(name: String, range: IntRange) = forInt(name, range.toSet())

        /**
         * Creates a new enum property with the given [name], [type], and the given
         * set of accepted [values].
         *
         * @param name the name
         * @param type the enum class
         * @param values the set of accepted values
         * @return a new enum property
         */
        @JvmStatic
        fun <E> forEnum(name: String, type: Class<E>, values: Set<E>) where E : Enum<E>, E : StringSerializable = FACTORY.forEnum(name, type, values)

        /**
         * Creates a new enum property with the given [name], [type], and the given
         * array of accepted [values].
         *
         * @param name the name
         * @param type the enum class
         * @param values the array of accepted values
         * @return a new enum property
         */
        @JvmStatic
        fun <E> forEnum(
            name: String,
            type: Class<E>,
            values: Array<E>
        ) where E : Enum<E>, E : StringSerializable = FACTORY.forEnum(name, type, values.toSet())
    }
}

/**
 * Creates a new enum property with the given [name] and the given set
 * of accepted [values].
 *
 * @param name the name
 * @param values the set of accepted values
 * @return a new enum property
 */
@JvmSynthetic
inline fun <reified E> Property.Companion.forEnum(
    name: String,
    values: Set<E>
) where E : Enum<E>, E : StringSerializable = forEnum(name, E::class.java, values)

/**
 * Creates a new enum property with the given [name] and the given array
 * of accepted [values].
 *
 * @param name the name
 * @param values the array of accepted values
 * @return a new enum property
 */
@JvmSynthetic
inline fun <reified E> Property.Companion.forEnum(
    name: String,
    values: Array<E>
) where E : Enum<E>, E : StringSerializable = forEnum(name, E::class.java, values)

private val FACTORY = FACTORY_PROVIDER.provide<Property.Factory>()