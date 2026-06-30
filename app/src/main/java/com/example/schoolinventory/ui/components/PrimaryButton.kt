package com.example.schoolinventory.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun PrimaryButton(
  text: String,
  icon: ImageVector,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Button(
    onClick = onClick,
    modifier = modifier
      .padding(8.dp),
    shape = MaterialTheme.shapes.large,
    colors = ButtonDefaults.buttonColors(
      containerColor = MaterialTheme.colorScheme.onBackground,
      contentColor = MaterialTheme.colorScheme.background,
    )
  ) {
    Icon(
      imageVector = icon,
      contentDescription = null,
      modifier = Modifier.padding(end = 8.dp)
    )
    Text(
      text = text,
      style = MaterialTheme.typography.bodyLarge,
      fontWeight = FontWeight.Bold,
      modifier = Modifier.padding(vertical = 8.dp)
    )
  }
}
