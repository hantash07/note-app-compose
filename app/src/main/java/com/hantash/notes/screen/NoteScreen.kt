package com.hantash.notes.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hantash.notes.components.NoteButton
import com.hantash.notes.components.NoteTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen() {
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
            MainContent(modifier = Modifier.padding(innerPadding))
        }
    )
}

@Composable
private fun MainContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NoteTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "Title",
            text = "",
            onTextChange = {

            }
        )
        NoteTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp),
            label = "Description",
            text = "",
            onTextChange = {

            }
        )
        NoteButton(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            btnName = "Add Note",
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun NoteScreenPreview() {
    NoteScreen()
}