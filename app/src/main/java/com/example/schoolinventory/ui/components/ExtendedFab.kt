package com.example.schoolinventory.ui.components





import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ExtendedFab(
  onClick: () -> Unit,
  modifier: Modifier = Modifier
){
  ExtendedFloatingActionButton(
    onClick = {},
    icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = null) },
    text = { Text("Agregar") },
    modifier = modifier,
  )
}