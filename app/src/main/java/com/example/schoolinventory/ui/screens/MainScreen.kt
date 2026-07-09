package com.example.schoolinventory.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.schoolinventory.navigation.AppScreens
import com.example.schoolinventory.ui.components.ExpressiveFabMenu
import com.example.schoolinventory.ui.components.InventoryCard
import com.example.schoolinventory.viewmodel.InventoryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
  viewModel: InventoryViewModel = viewModel(),
  navController: NavController
) {
  val inventoryList by viewModel.items.collectAsState()

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Text(
            "Inventario",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
          )
        }
      )
    },
    floatingActionButton = {
      ExpressiveFabMenu(
        onExportClick = {},
        onCreateInventoryClick = { navController.navigate(AppScreens.AddInventory) },
        modifier = Modifier,
      )
    }

  ) { innerPadding ->
    LazyVerticalGrid(
      columns = GridCells.Fixed(2),
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding),
      contentPadding = PaddingValues(8.dp),
    ) {
      items(inventoryList) { inventory ->
        InventoryCard(
          item = inventory,
          onClick = {
            viewModel.selectItem(inventory)
            navController.navigate(AppScreens.ItemDetailScreen)
          },
          modifier = Modifier
//            .aspectRatio(1f),
        )
      }
    }
  }
}