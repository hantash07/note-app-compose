package com.hantash.notes.data

import com.hantash.notes.model.Note

class NoteDataSource {

    fun fetchNotes() : List<Note> {
        return listOf(
            Note(title = "Title 1", description = "Description of Title 1"),
            Note(title = "Title 2", description = "Description of Title 2"),
            Note(title = "Title 3", description = "Description of Title 3"),
//            Note(title = "Title 4", description = "Description of Title 4"),
//            Note(title = "Title 5", description = "Description of Title 5"),
//            Note(title = "Title 6", description = "Description of Title 6"),
//            Note(title = "Title 7", description = "Description of Title 7"),
//            Note(title = "Title 8", description = "Description of Title 8"),
        )
    }

}