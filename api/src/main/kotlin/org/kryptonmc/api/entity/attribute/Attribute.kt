/*
 * This file is part of the Krypton API, licensed under the MIT license.
 *
 * Copyright (C) 2021 KryptonMC and the contributors to the Krypton project.
 *
 * This project is licensed under the terms of the MIT license.
 * For more details, please reference the LICENSE file in the api top-level directory.
 */
package org.kryptonmc.api.entity.attribute

/**
 * Represents an attribute that can be applied to a living entity.
 */
interface Attribute {

    /**
     * The name of this attribute
     */
    val name: String
        get() = type.key.value()

    /**
     * The type of this attribute.
     */
    val type: AttributeType

    /**
     * The base value of this attribute.
     */
    var baseValue: Double

    /**
     * The cached calculated value of this attribute.
     *
     * Use [recalculate] to recalculate this value.
     * Adding modifiers will
     */
    val value: Double

    /**
     * The modifiers used to modify the [baseValue] in calculation to get the
     * [value].
     */
    val modifiers: Map<ModifierOperation, List<AttributeModifier>>

    /**
     * Gets all modifiers stored under the given [operation].
     *
     * @param operation the operation
     * @return all modifiers for the given operation
     */
    fun getModifiers(operation: ModifierOperation): List<AttributeModifier>

    /**
     * Adds the given [modifier] to the list of modifiers under the given
     * [operation].
     *
     * @param operation the operation
     * @param modifier the modifier to add
     */
    fun addModifier(operation: ModifierOperation, modifier: AttributeModifier)

    /**
     * Removes the given [modifier] from the list of modifiers under the given
     * [operation].
     *
     * @param operation the operation
     * @param modifier the modifier to remove
     */
    fun removeModifier(operation: ModifierOperation, modifier: AttributeModifier)

    /**
     * Removes all modifiers under the given [operation].
     *
     * @param operation the operation
     */
    fun removeModifiers(operation: ModifierOperation)

    /**
     * Forces this attribute's [value] to be recalculated.
     */
    fun recalculate()
}