package com.example.schoolinventory.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.schoolinventory.data.model.Inventory
import com.example.schoolinventory.ui.utils.getItemIcon

@Composable
fun InventoryCard(
  item: Inventory,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
) {


  Card(
    modifier = modifier
      .clickable { onClick() }
      .padding(4.dp),
    shape = MaterialTheme.shapes.large,
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
    ),
    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
  ) {
    Column(
      modifier = Modifier.padding(12.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
      ) {
        Box(
          modifier = Modifier
            .size(48.dp)
            .background(
              color = MaterialTheme.colorScheme.surface,
              shape = MaterialTheme.shapes.medium,
            ),
          contentAlignment = Alignment.Center,
        ) {
          Icon(
            imageVector = getItemIcon(item.description),
            contentDescription = null,
            modifier = Modifier.size(26.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
          )
        }
        ConditionBadge(condition = item.state)
      }

      Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(
          text = item.description,
          style = MaterialTheme.typography.titleMedium,
          fontWeight = FontWeight.Bold,
          maxLines = 2,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier
            .fillMaxWidth()
        )
        Text(
          text = item.brand,
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier
            .fillMaxWidth()
        )
      }

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
      ) {
        Column {
          Text(
            text = item.quantity.toString(),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
          )
          Text(
            text = "Existentes",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            letterSpacing = 1.sp,
          )
        }
        Text(
          text = item.serie,
          style = MaterialTheme.typography.labelSmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier
            .fillMaxWidth()
        )
      }
    }
  }
}