package com.hantash.notes.di

import android.content.Context
import androidx.room.Room
import com.hantash.notes.data.NoteDao
import com.hantash.notes.data.NoteDatabase
import com.hantash.notes.repo.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @AppScope
    fun appDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(context,
            NoteDatabase::class.java,
            name = "note_db"
        ).fallbackToDestructiveMigrationFrom().build()
    }

    @Provides
    @AppScope
    fun noteDao(noteDatabase: NoteDatabase): NoteDao = noteDatabase.noteDao()

//    @Provides
//    @AppScope
//    fun repoNote(noteDao: NoteDao): NoteRepository = NoteRepository(noteDao)
}