package com.example.schoolinventory.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Notes
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.Notes
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material.icons.outlined.Tag
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InfoCard(
  serieText: String,
  quantityText: String,
  conditionText: String,
  observationText: String,
  modifier: Modifier = Modifier,
) {
  Card(
    modifier = modifier
      .fillMaxWidth(),
    shape = MaterialTheme.shapes.medium
  ) {
    Column(
      modifier = Modifier
        .padding(8.dp),
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        Icon(
          imageVector = Icons.Outlined.Tag,
          contentDescription = ""
        )
        Column(
          modifier = Modifier,
          verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
          Text(
            text = "Numero de serie",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )

          Text(
            text = serieText,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
          )
        }
      }

      HorizontalDivider(
        modifier = Modifier.padding(horizontal = 16.dp),
        color = MaterialTheme.colorScheme.outlineVariant,
      )

      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        Icon(
          imageVector = Icons.Outlined.Inventory2,
          contentDescription = ""
        )
        Column(
          modifier = Modifier,
          verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
          Text(
            text = "Cantidad",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )

          Text(
            text = quantityText,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
          )
        }
      }

      HorizontalDivider(
        modifier = Modifier.padding(horizontal = 16.dp),
        color = MaterialTheme.colorScheme.outlineVariant,
      )

      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        Icon(
          imageVector = Icons.Default.HealthAndSafety,
          contentDescription = ""
        )
        Column(
          modifier = Modifier,
          verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
          Text(
            text = "Condición",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )

          Text(
            text = conditionText,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
          )
        }
      }

      HorizontalDivider(
        modifier = Modifier.padding(horizontal = 16.dp),
        color = MaterialTheme.colorScheme.outlineVariant,
      )

      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        Icon(
          imageVector = Icons.Default.Notes,
          contentDescription = ""
        )
        Column(
          modifier = Modifier,
          verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
          Text(
            text = "Observaciones",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )

          Text(
            text = observationText,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
          )
        }
      }
    }
  }
}