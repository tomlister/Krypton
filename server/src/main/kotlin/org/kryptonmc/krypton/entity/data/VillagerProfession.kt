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
package org.kryptonmc.krypton.entity.data

import net.kyori.adventure.key.Key

/**
 * Professions of villagers.
 */
enum class VillagerProfession {

    NONE,
    ARMORER,
    BUTCHER,
    CARTOGRAPHER,
    CLERIC,
    FARMER,
    FISHERMAN,
    FLETCHER,
    LEATHERWORKER,
    LIBRARIAN,
    MASON,
    NITWIT,
    SHEPHERD,
    TOOLSMITH,
    WEAPONSMITH;

    val key: Key by lazy { Key.key(name.lowercase()) }
}
