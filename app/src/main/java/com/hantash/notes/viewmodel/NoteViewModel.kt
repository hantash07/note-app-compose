package com.hantash.notes.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.hantash.notes.data.NoteDataSource
import com.hantash.notes.model.Note

class NoteViewModel: ViewModel() {
    private val noteStateList = mutableStateListOf<Note>()

    init {
        noteStateList.addAll(NoteDataSource().fetchNotes())
    }

    fun addNote(note: Note) {
        noteStateList.add(note)
    }

    fun removeNote(note: Note) {
        noteStateList.remove(note)
    }

    fun fetchNotes(): List<Note> {
        return noteStateList
    }

}