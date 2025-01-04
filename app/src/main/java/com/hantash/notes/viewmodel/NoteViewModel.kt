package com.hantash.notes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hantash.notes.model.Note
import com.hantash.notes.repo.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository): ViewModel() {
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch {
            noteRepository.fetchNotes()
                .distinctUntilChanged().collect { notes ->
                    _noteList.value = notes
            }
        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            noteRepository.addNote(note)
        }
    }

    fun removeNote(note: Note) {
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }

//    fun fetchNotes(): List<Note> {
//        return noteRepository.fetchNotes()
//    }

}