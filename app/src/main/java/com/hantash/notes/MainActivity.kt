package com.hantash.notes

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hantash.notes.data.NoteDataSource
import com.hantash.notes.model.Note
import com.hantash.notes.screen.NoteScreen
import com.hantash.notes.ui.theme.NoteappcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteappcomposeTheme {
                val noteList = remember {
                    mutableStateListOf<Note>()
                }
                NoteScreen(
                    notes = noteList,
                    onAddNote = {
                        noteList.add(it)
                        Toast.makeText(this, "Note Added Successfully!", Toast.LENGTH_SHORT).show()
                    },
                    onRemoveNote = {
                        noteList.remove(it)
                        Toast.makeText(this, "Note Removed Successfully!", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteappcomposeTheme {

    }
}