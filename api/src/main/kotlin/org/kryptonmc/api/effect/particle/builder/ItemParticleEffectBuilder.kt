/*
 * This file is part of the Krypton API, licensed under the MIT license.
 *
 * Copyright (C) 2021 KryptonMC and the contributors to the Krypton project.
 *
 * This project is licensed under the terms of the MIT license.
 * For more details, please reference the LICENSE file in the api top-level directory.
 */
package org.kryptonmc.api.effect.particle.builder

import org.jetbrains.annotations.Contract
import org.kryptonmc.api.effect.particle.ParticleDsl
import org.kryptonmc.api.effect.particle.ParticleEffect
import org.kryptonmc.api.effect.particle.ParticleType
import org.kryptonmc.api.effect.particle.data.ItemParticleData
import org.kryptonmc.api.item.ItemType
import org.kryptonmc.api.item.ItemTypes
import org.spongepowered.math.vector.Vector3d

/**
 * Allows building a [ParticleEffect] for item particle effects using method
 * chaining.
 */
public class ItemParticleEffectBuilder @JvmOverloads constructor(
    type: ParticleType,
    quantity: Int = 1,
    offset: Vector3d = Vector3d.ZERO,
    longDistance: Boolean = false,
    private var item: ItemType = ItemTypes.AIR
) : AbstractParticleEffectBuilder<ItemParticleEffectBuilder>(type, quantity, offset, longDistance) {

    /**
     * Sets the item data of the texture to be used.
     *
     * @param item the item type to use
     */
    @ParticleDsl
    @Contract("_ -> this", mutates = "this")
    public fun item(item: ItemType): ItemParticleEffectBuilder = apply { this.item = item }

    /**
     * Builds a new [ParticleEffect] from the settings of this builder.
     */
    @Contract("_ -> new", pure = true)
    override fun build(): ParticleEffect = ParticleEffect.of(type, quantity, offset, longDistance, ItemParticleData.of(item))
}
