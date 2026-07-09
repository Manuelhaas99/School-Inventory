package com.example.schoolinventory.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ImagePickerButton(
  imagePath: String?,
  onCameraClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  if (imagePath != null) {
    // Muestra la imagen tomada
    AsyncImage(
      model = imagePath,
      contentDescription = null,
      modifier = modifier
        .fillMaxWidth()
        .aspectRatio(4f / 3f)
        .clip(MaterialTheme.shapes.large)
        .clickable { onCameraClick() },
      contentScale = ContentScale.Crop,
    )
  } else {
    // Placeholder cuando no hay imagen
    Box(
      modifier = modifier
        .fillMaxWidth()
        .aspectRatio(4f / 3f)
        .clip(MaterialTheme.shapes.large)
        .background(MaterialTheme.colorScheme.surfaceVariant)
        .clickable { onCameraClick() },
      contentAlignment = Alignment.Center,
    ) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        Icon(
          imageVector = Icons.Outlined.CameraAlt,
          contentDescription = null,
          modifier = Modifier.size(32.dp),
          tint = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Text(
          text = "Take photo",
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
      }
    }
  }
}