package com.example.schoolinventory.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuantityStepper(
  quantity: Int,
  onIncrement: () -> Unit,
  onDecrement: () -> Unit,
  modifier: Modifier = Modifier
) {
  Row(
    modifier = modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(24.dp)) // Curvas más expresivas
      .background(MaterialTheme.colorScheme.surfaceVariant)
      // Aumentamos el padding superior e inferior para hacerlo más alto
      .padding(horizontal = 20.dp, vertical = 20.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Column {
      Text("Quantity", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 14.sp)
      // Texto mucho más grande (36.sp)
      Text("$quantity", color = MaterialTheme.colorScheme.onSurface, fontSize = 36.sp, fontWeight = FontWeight.Bold)
    }
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
      FilledIconButton(
        onClick = { onDecrement() },
        shape = RoundedCornerShape(20.dp),
        colors = IconButtonDefaults.filledIconButtonColors(
          containerColor = MaterialTheme.colorScheme.surface,
          contentColor = MaterialTheme.colorScheme.onSurface
        ),
        // Botones más grandes
        modifier = Modifier.size(60.dp)
      ) { Icon(Icons.Rounded.Remove, "Decrease", modifier = Modifier.size(24.dp)) }

      FilledIconButton(
        onClick = { onIncrement() },
        shape = RoundedCornerShape(20.dp),
        colors = IconButtonDefaults.filledIconButtonColors(
          containerColor = MaterialTheme.colorScheme.onSurface,
          contentColor = MaterialTheme.colorScheme.surface
        ),
        // Botones más grandes
        modifier = Modifier.size(60.dp)
      ) { Icon(Icons.Rounded.Add, "Increase", modifier = Modifier.size(24.dp)) }
    }
  }
}