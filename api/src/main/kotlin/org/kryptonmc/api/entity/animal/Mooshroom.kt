/*
 * This file is part of the Krypton API, licensed under the MIT license.
 *
 * Copyright (C) 2021 KryptonMC and the contributors to the Krypton project.
 *
 * This project is licensed under the terms of the MIT license.
 * For more details, please reference the LICENSE file in the api top-level directory.
 */
package org.kryptonmc.api.entity.animal

import org.kryptonmc.api.entity.animal.type.MooshroomType

/**
 * A mooshroom.
 */
@Suppress("INAPPLICABLE_JVM_NAME")
public interface Mooshroom : Cow {

    /**
     * The type of this mooshroom.
     */
    @get:JvmName("mooshroomType")
    public var mooshroomType: MooshroomType
}
