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
package org.kryptonmc.krypton.server.ban

import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import org.kryptonmc.krypton.auth.KryptonGameProfile
import java.time.OffsetDateTime
import java.time.format.DateTimeParseException
import java.util.UUID

class BannedPlayerEntry(
    profile: KryptonGameProfile,
    creationDate: OffsetDateTime = OffsetDateTime.now(),
    source: String = "(Unknown)",
    expiryDate: OffsetDateTime? = null,
    reason: String = "Banned by operator."
) : BanEntry<KryptonGameProfile>(profile, creationDate, source, expiryDate, reason) {

    override fun writeKey(writer: JsonWriter) {
        writer.name("uuid")
        writer.value(key.uuid.toString())
        writer.name("name")
        writer.value(key.name)
    }

    companion object {

        fun read(reader: JsonReader): BannedPlayerEntry? {
            reader.beginObject()

            var name: String? = null
            var uuid: UUID? = null
            var creationDate: OffsetDateTime = OffsetDateTime.now()
            var source = "(Unknown)"
            var expires: OffsetDateTime? = null
            var reason = "Banned by operator."
            while (reader.hasNext()) {
                when (reader.nextName()) {
                    "name" -> name = reader.nextString()
                    "uuid" -> uuid = UUID.fromString(reader.nextString())
                    "created" -> creationDate = try {
                        OffsetDateTime.parse(reader.nextString(), DATE_FORMATTER)
                    } catch (_: DateTimeParseException) {
                        OffsetDateTime.now()
                    }
                    "source" -> source = reader.nextString()
                    "expires" -> expires = try {
                        OffsetDateTime.parse(reader.nextString(), DATE_FORMATTER)
                    } catch (_: DateTimeParseException) {
                        null
                    }
                    "reason" -> reason = reader.nextString()
                }
            }

            reader.endObject()
            if (name == null || uuid == null) return null
            return BannedPlayerEntry(KryptonGameProfile(uuid, name, emptyList()), creationDate, source, expires, reason)
        }
    }
}
