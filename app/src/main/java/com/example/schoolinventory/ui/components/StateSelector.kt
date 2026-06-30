package com.example.schoolinventory.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.History
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StateSelector(
  modifier: Modifier = Modifier
) {
  val opciones = listOf(
    Pair("New", Icons.Rounded.AutoAwesome),
    Pair("Used", Icons.Rounded.History),
    Pair("Broken", Icons.Rounded.Build)
  )

  // Variable interna (Mock) para que sea modular sin pedir parámetros externos aún
  var indiceSeleccionado by remember { mutableIntStateOf(0) }

  Column(modifier = modifier.fillMaxWidth()) {
    Text(
      text = "State",
      color = MaterialTheme.colorScheme.onSurfaceVariant,
      fontSize = 14.sp,
      modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
    )

    Row(
      modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(24.dp)) // Contenedor muy curvo
        .background(MaterialTheme.colorScheme.surfaceVariant)
        // Más padding interno para que la píldora se vea "abrazada"
        .padding(8.dp),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      opciones.forEachIndexed { index, option ->
        val isSelected = indiceSeleccionado == index

        Row(
          modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(50)) // Forma de píldora perfecta
            .background(if (isSelected) MaterialTheme.colorScheme.onSurface else Color.Transparent)
            .clickable { indiceSeleccionado = index }
            // Padding vertical más grande para que sea alta como la imagen
            .padding(vertical = 16.dp),
          horizontalArrangement = Arrangement.Center,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Icon(
            imageVector = option.second,
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = if (isSelected) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.onSurfaceVariant
          )
          Spacer(Modifier.width(8.dp))
          Text(
            text = option.first,
            color = if (isSelected) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.onSurface,
            fontSize = 15.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
          )
        }
      }
    }
  }
}

