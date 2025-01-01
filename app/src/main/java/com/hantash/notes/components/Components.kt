package com.hantash.notes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun NoteTextField(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {}
) {
    TextField(
        modifier = modifier,
        onValueChange = onTextChange,
        value = text,
        label = { Text(text = label) },
        textStyle = TextStyle(
            color = Color.Black
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
            }
        )
    )
}

@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    btnName: String,
    enable: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        enabled = enable,
        shape = CircleShape,
        onClick = onClick,
    ) {
        Text(
            text = btnName,
            style = MaterialTheme.typography.titleMedium
        )
    }
}



















