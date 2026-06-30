package com.example.schoolinventory.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.schoolinventory.navigation.AppScreens
import com.example.schoolinventory.ui.components.ExtendedFab
import com.example.schoolinventory.ui.components.InventoryCard
import com.example.schoolinventory.viewmodel.InventoryViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
  viewModel: InventoryViewModel = viewModel(),
  navController: NavController
) {
  Scaffold(
    floatingActionButton = {
      ExtendedFab(
        onClick = { navController.navigate(AppScreens.AddInventory) },
        text = "Agregar",
        icon = Icons.Filled.Add
      )
    }

  ) { innerPadding ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding),
    ) {
      items(20) { cards ->
        InventoryCard(
          navController
        )
      }
    }
  }
}