package com.hantash.notes.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hantash.notes.components.NoteButton
import com.hantash.notes.components.NoteTextField
import com.hantash.notes.data.NoteDataSource
import com.hantash.notes.model.Note
import com.hantash.notes.utils.formatDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "My Notes") },
                actions = {
                    Icon(
                        imageVector = Icons.Rounded.Notifications,
                        contentDescription = "Notification Icon"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        },
        content = { innerPadding ->
            MainContent(modifier = Modifier.padding(innerPadding), notes, onAddNote, onRemoveNote)
        }
    )
}

@Composable
private fun MainContent(
    modifier: Modifier = Modifier,
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {
    var titleState by remember {
        mutableStateOf("")
    }
    var descState by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.End
    ) {
        NoteTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "Title",
            text = titleState,

            onTextChange = {
                if (it.all { char -> char.isLetter() || char.isWhitespace() }) titleState = it
            }
        )
        NoteTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp),
            label = "Description",
            text = descState,
            onTextChange = {
                if (it.all { char -> char.isLetter() || char.isWhitespace() }) descState = it
            }
        )
        NoteButton(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            btnName = "Add Note",
            onClick = {
                if (titleState.isEmpty()) {
                    Toast.makeText(context, "Please Enter Title", Toast.LENGTH_SHORT).show()
                    return@NoteButton
                }

                if (descState.isEmpty()) {
                    Toast.makeText(context, "Please Enter Descriptions", Toast.LENGTH_SHORT).show()
                    return@NoteButton
                }

                if (titleState.isNotEmpty() && descState.isNotEmpty()) {
                    onAddNote(Note(title = titleState, description = descState))

                    titleState = ""
                    descState = ""
                }
            }
        )

        HorizontalDivider(modifier = Modifier.padding(5.dp))

        LazyColumn {
            items(items = notes) { note ->
                NoteRow(
                    note = note,
                    onClickNote = onRemoveNote
                )
            }
        }
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onClickNote: (Note) -> Unit
) {
    Surface(
        modifier.padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 32.dp, bottomStart = 32.dp))
            .fillMaxWidth(),
        color = Color(0xFFDFE6EB)
    ) {
        Column(
            modifier.clickable {
                onClickNote(note)
            }
                .padding(horizontal = 12.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = note.description,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                modifier = Modifier.align(Alignment.End),
                text = formatDate(note.entryDate.time),
                style = MaterialTheme.typography.bodySmall,
                fontStyle = FontStyle.Italic
            )
        }
    }
}

@Preview
@Composable
private fun NoteScreenPreview() {
    NoteScreen(
        notes = NoteDataSource().fetchNotes(),
        onAddNote = {},
        onRemoveNote = {}
    )
}
















