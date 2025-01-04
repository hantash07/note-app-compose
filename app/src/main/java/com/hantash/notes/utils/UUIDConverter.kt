package com.hantash.notes.utils

import androidx.room.TypeConverter
import java.util.UUID

class UUIDConverter {
    @TypeConverter
    fun fromUUID(uuid: UUID): String {
        return uuid.toString()
    }

    @TypeConverter
    fun uuidFromString(uuidStr: String): UUID {
        return UUID.fromString(uuidStr)
    }
}