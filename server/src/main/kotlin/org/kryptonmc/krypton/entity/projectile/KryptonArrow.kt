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
package org.kryptonmc.krypton.entity.projectile

import org.kryptonmc.api.entity.EntityTypes
import org.kryptonmc.api.entity.projectile.Arrow
import org.kryptonmc.krypton.entity.metadata.MetadataKeys
import org.kryptonmc.krypton.world.KryptonWorld
import org.kryptonmc.nbt.CompoundTag
import java.awt.Color

class KryptonArrow(world: KryptonWorld) : KryptonArrowLike(world, EntityTypes.ARROW), Arrow {

    override var color: Int
        get() = data[MetadataKeys.ARROW.COLOR]
        set(value) = data.set(MetadataKeys.ARROW.COLOR, value)

    init {
        data.add(MetadataKeys.ARROW.COLOR)
    }

    override fun load(tag: CompoundTag) {
        super.load(tag)
        if (tag.contains("Color", 99)) {
            val rgb = tag.getInt("Color")
            if (rgb in 0..RGB_MAX_VALUE) color = tag.getInt("Color")
        }
    }

    override fun save(): CompoundTag.Builder = super.save().apply {
        int("Color", color)
    }

    companion object {

        private const val RGB_MAX_VALUE = 16777215
    }
}
