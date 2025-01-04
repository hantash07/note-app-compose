package com.hantash.notes.repo

import com.hantash.notes.data.NoteDao
import com.hantash.notes.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {
    fun fetchNotes(): Flow<List<Note>> = noteDao.fetchNotes().flowOn(Dispatchers.IO).conflate()
    suspend fun addNote(note: Note) = noteDao.insert(note)
    suspend fun updateNote(note: Note) = noteDao.update(note)
    suspend fun deleteNote(note: Note) = noteDao.delete(note)
    suspend fun deleteAllNotes() = noteDao.deleteAll()
}