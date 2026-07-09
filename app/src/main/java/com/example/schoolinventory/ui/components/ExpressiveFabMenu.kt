package com.example.schoolinventory.ui.components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp

@Composable
fun ExpressiveFabMenu(
  onExportClick: () -> Unit,
  onCreateInventoryClick: () -> Unit,
  modifier: Modifier = Modifier,
) {

  var expanded by remember { mutableStateOf(false) }

  val rotation by animateFloatAsState(
    targetValue = if (expanded) 45f else 0f,
    animationSpec = spring(
      dampingRatio = Spring.DampingRatioNoBouncy,
      stiffness = Spring.StiffnessLow
    ),
    label = "Expressive_fab_rotation"
  )

  Column(
    horizontalAlignment = Alignment.End,
    verticalArrangement = Arrangement.spacedBy(16.dp),
    modifier = Modifier
      .padding(16.dp)
  ) {
    AnimatedVisibility(
      visible = expanded,
      enter = scaleIn(
        animationSpec = spring(
          dampingRatio = Spring.DampingRatioMediumBouncy,
          stiffness = Spring.StiffnessMediumLow
        ),
        initialScale = 0.8f
      ) + fadeIn(
        animationSpec = spring(
          dampingRatio = Spring.DampingRatioNoBouncy,
          stiffness = Spring.StiffnessMedium
        )
      ),
      exit = scaleOut(
        animationSpec = spring(
          dampingRatio = Spring.DampingRatioNoBouncy,
          stiffness = Spring.StiffnessMedium
        ),
        targetScale = 0.8f,
      ) + fadeOut(
        animationSpec = spring(
          dampingRatio = Spring.DampingRatioNoBouncy,
          stiffness = Spring.StiffnessMediumLow
        )
      )
    ) {
      Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        ExtendedFloatingActionButton(
          text = { Text("Exportar PDF") },
          icon = { Icon(Icons.Default.Create, contentDescription = "Exportar PDF") },
          onClick = {
            expanded = false
            onExportClick()
          },
          containerColor = MaterialTheme.colorScheme.tertiaryContainer,
          contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
        )

        ExtendedFloatingActionButton(
          text = { Text("Crear inventario") },
          icon = { Icon(Icons.Default.Create, contentDescription = "Crear inventario") },
          onClick = {
            expanded = false
            onCreateInventoryClick()
          },
          containerColor = MaterialTheme.colorScheme.tertiaryContainer
        )
      }
    }
    FloatingActionButton(
      onClick = { expanded = !expanded },
      containerColor = MaterialTheme.colorScheme.primary,
      contentColor = MaterialTheme.colorScheme.onPrimary,
      shape = CircleShape
    ) {
      Icon(
        Icons.Default.Add,
        contentDescription = if (expanded) "Close" else "Expand",
        modifier = Modifier.rotate(rotation)
      )
    }
  }
}