package com.example.schoolinventory.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.LocalOffer
import androidx.compose.material.icons.outlined.PictureAsPdf
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.schoolinventory.R
import com.example.schoolinventory.data.model.ItemState
import com.example.schoolinventory.navigation.AppScreens
import com.example.schoolinventory.ui.components.InfoCard
import com.example.schoolinventory.ui.components.InfoChip
import com.example.schoolinventory.ui.components.PrimaryButton
import com.example.schoolinventory.ui.components.QuantityBadge
import com.example.schoolinventory.viewmodel.InventoryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemDetailScreen(
  viewModel: InventoryViewModel = viewModel(),
  navController: NavController,
) {
  val selectItem by viewModel.selectItem.collectAsState()

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Text(
            text = "Detalle del producto",
            modifier = Modifier
              .padding(horizontal = 8.dp)
          )
        },
        navigationIcon = {
          IconButton(
            onClick = {
              navController.navigate(AppScreens.MainScreen)
            },
            modifier = Modifier
//              .background(
//                color = MaterialTheme.colorScheme.onBackground,
//                shape = CircleShape
//              ),
          ) {
            Icon(
              imageVector = Icons.Default.ArrowBack,
              contentDescription = "Icon button to go back",
//              tint = MaterialTheme.colorScheme.background,
            )
          }
        }
      )
    },
    bottomBar = {
      PrimaryButton(
        onClick = {},
        text = "Exportar PDF",
        icon = Icons.Outlined.PictureAsPdf,
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp),
      )
    }
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .padding(horizontal = 16.dp),
    ) {

      AsyncImage(
        model = selectItem?.imagePath ?: R.drawable.ic_launcher_background,
        contentDescription = null,
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 16.dp, bottom = 8.dp)
          .aspectRatio(4f / 3f)
          .clip(MaterialTheme.shapes.large),
        contentScale = ContentScale.Crop,
      )
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = selectItem?.description ?: "",
          style = MaterialTheme.typography.headlineMedium,
          color = MaterialTheme.colorScheme.onBackground,
          maxLines = 2,
          softWrap = true,
          modifier = Modifier
            .weight(1f),
        )
        QuantityBadge(
          quantityText = selectItem?.quantity.toString(),
          modifier = Modifier.padding(start = 12.dp)
        )
      }
      Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.padding(vertical = 4.dp)
      ) {
        Icon(
          imageVector = Icons.Outlined.LocalOffer,
          contentDescription = null,
          tint = MaterialTheme.colorScheme.onSurfaceVariant,
          modifier = Modifier.size(16.dp)
        )
        Text(
          text = selectItem?.description ?: "",
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
      }
      InfoChip(
        label = (selectItem?.state ?: ItemState.UNSELECTED) as String,
        modifier = Modifier
          .padding(vertical = 4.dp),
      )
      InfoCard(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 8.dp),
        serieText = selectItem?.serie ?: "",
        quantityText = selectItem?.quantity.toString(),
        conditionText = (selectItem?.state ?: ItemState.UNSELECTED) as String,
        observationText = (selectItem?.observation ?: "")
      )
    }
  }
}