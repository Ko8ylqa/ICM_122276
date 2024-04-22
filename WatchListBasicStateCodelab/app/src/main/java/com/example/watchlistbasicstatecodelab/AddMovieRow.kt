package com.example.watchlist

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddMovieRow(
    onAddMovie: (String) -> Unit
) {
    var title by remember { mutableStateOf("") }

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = {title = it },
            label = { Text("Enter Movie Title") },
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = {
                if (title.isNotBlank()) {
                    onAddMovie(title)
                    title = ""
                }
            }
        ) {
            Text("Add")
        }
    }

}