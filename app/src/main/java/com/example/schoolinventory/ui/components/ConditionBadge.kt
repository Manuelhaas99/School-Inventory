package com.example.schoolinventory.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ConditionBadge(condition: String) {
  val (bgColor, textColor, dotColor) = when (condition.lowercase()) {
    "good" -> Triple(
      Color(0xFFE8F5E9),
      Color(0xFF2E7D32),
      Color(0xFF4CAF50)
    )

    "new" -> Triple(
      Color(0xFFE3F2FD),
      Color(0xFF1565C0),
      Color(0xFF2196F3)
    )

    "worn" -> Triple(
      Color(0xFFFFF3E0),
      Color(0xFFE65100),
      Color(0xFFFF9800)
    )

    "repair" -> Triple(
      Color(0xFFFCE4EC),
      Color(0xFFB71C1C),
      Color(0xFFF44336)
    )

    else -> Triple(
      MaterialTheme.colorScheme.surfaceVariant,
      MaterialTheme.colorScheme.onSurfaceVariant,
      MaterialTheme.colorScheme.onSurfaceVariant
    )
  }

  Row(
    modifier = Modifier
      .background(color = bgColor, shape = MaterialTheme.shapes.extraLarge)
      .padding(horizontal = 8.dp, vertical = 4.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(4.dp),
  ) {
    Box(
      modifier = Modifier
        .size(6.dp)
        .background(color = dotColor, shape = CircleShape)
    )
    Text(
      text = condition,
      style = MaterialTheme.typography.labelSmall,
      color = textColor,
      fontWeight = FontWeight.Medium,
    )
  }
}