package com.example.schoolinventory.ui.components

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp


@Composable
fun InventoryTextField(
  value: String,
  onValueChange: (String) -> Unit,
  label: String,
  placeholder: String,
  modifier: Modifier = Modifier,
  minLines: Int = 1,
  singleLine: Boolean = false,
  trailingIcon: @Composable (() -> Unit)? = null
) {
  TextField(
    value = value,
    onValueChange = onValueChange,
    label = { Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant) },
    placeholder = { Text(placeholder) },
    minLines = minLines,
    singleLine = singleLine,
    trailingIcon = trailingIcon,
    // Curvas mucho más pronunciadas (24.dp en lugar de 16.dp)
    shape = RoundedCornerShape(24.dp),
    colors = TextFieldDefaults.colors(
      focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
      unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
      // Quitamos la línea inferior
      focusedIndicatorColor = Color.Transparent,
      unfocusedIndicatorColor = Color.Transparent,
    ),
    modifier = modifier
      .fillMaxWidth()
      // Esto obliga al campo a ser más alto por defecto
      .defaultMinSize(minHeight = 72.dp)
  )
}