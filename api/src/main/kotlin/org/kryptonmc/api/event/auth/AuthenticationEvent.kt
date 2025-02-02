/*
 * This file is part of the Krypton API, licensed under the MIT license.
 *
 * Copyright (C) 2021 KryptonMC and the contributors to the Krypton project.
 *
 * This project is licensed under the terms of the MIT license.
 * For more details, please reference the LICENSE file in the api top-level directory.
 */
package org.kryptonmc.api.event.auth

import org.kryptonmc.api.auth.GameProfile
import org.kryptonmc.api.event.ResultedEvent
import org.kryptonmc.api.event.ResultedEvent.Result

/**
 * An event that is called when a request is made to authenticate a player with
 * the given [username].
 */
public data class AuthenticationEvent(@get:JvmName("username") public val username: String) : ResultedEvent<AuthenticationResult> {

    override var result: AuthenticationResult = AuthenticationResult.allowed(null)
}

/**
 * The result of a request to authenticate a player.
 *
 * @param profile the optional profile for a successful result
 */
@JvmRecord
public data class AuthenticationResult(
    override val isAllowed: Boolean,
    public val profile: GameProfile?
) : Result {

    public companion object {

        /**
         * Creates a result that allows the authenticating player to join the
         * server, optionally with the given [profile].
         *
         * Providing `null` to this function should cause the server to use the
         * profile it received from authenticating the user.
         */
        @JvmStatic
        @JvmOverloads
        public fun allowed(profile: GameProfile? = null): AuthenticationResult = AuthenticationResult(true, profile)

        /**
         * Creates a result that denies the authenticating player from joining
         * the server.
         */
        @JvmStatic
        public fun denied(): AuthenticationResult = AuthenticationResult(false, null)
    }
}
