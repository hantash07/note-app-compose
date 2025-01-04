package com.hantash.notes.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity(tableName = "note_table")   //Class name is the table name by default, if the tableName is not define explicitly
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val entryDate: Date = Date.from(Instant.now())
)
