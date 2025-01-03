package com.hantash.notes

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.hantash.notes.data.NoteDataSource
import com.hantash.notes.model.Note
import com.hantash.notes.screen.NoteScreen
import com.hantash.notes.ui.theme.NoteappcomposeTheme
import com.hantash.notes.viewmodel.NoteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteappcomposeTheme {
                val viewModel: NoteViewModel by viewModels()
                NoteApp(viewModel)
            }
        }
    }
}

@Composable
fun NoteApp(viewModel: NoteViewModel) {
    val context = LocalContext.current
    NoteScreen(
        notes = viewModel.fetchNotes(),
        onAddNote = {
            viewModel.addNote(it)
            Toast.makeText(context, "Note Added Successfully!", Toast.LENGTH_SHORT).show()
        },
        onRemoveNote = {
            viewModel.removeNote(it)
            Toast.makeText(context, "Note Removed Successfully!", Toast.LENGTH_SHORT).show()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteappcomposeTheme {
    }
}