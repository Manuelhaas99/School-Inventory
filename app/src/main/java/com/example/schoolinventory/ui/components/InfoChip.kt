package com.example.schoolinventory.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InfoChip(
  label: String,
  modifier: Modifier = Modifier
) {
  AssistChip(
    onClick = {},
    modifier = modifier,
    label = {
      Text(
        text = label,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier
          .padding(vertical = 8.dp),
      )
    },
    leadingIcon = {
      Icon(
        imageVector = Icons.Outlined.StarBorder,
        contentDescription = "",
        modifier = Modifier
          .padding(start = 4.dp)
      )
    },
    colors = AssistChipDefaults.assistChipColors(
      containerColor = MaterialTheme.colorScheme.onBackground,
      labelColor = MaterialTheme.colorScheme.background,
      leadingIconContentColor = MaterialTheme.colorScheme.background,
    ),
    border = null,
  )
}