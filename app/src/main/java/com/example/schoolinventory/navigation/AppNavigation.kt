package com.example.schoolinventory.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.schoolinventory.ui.screens.AddInventory
import com.example.schoolinventory.ui.screens.ItemDetailScreen
import com.example.schoolinventory.ui.screens.MainScreen
import com.example.schoolinventory.viewmodel.InventoryViewModel

@Composable
fun AppNavigation(
  modifier: Modifier = Modifier
){
  val navController = rememberNavController()
  val viewModel: InventoryViewModel = viewModel()


  NavHost(
    navController = navController,
    startDestination = AppScreens.MainScreen,
    modifier = modifier
  ){
    composable<AppScreens.MainScreen> {
      MainScreen(
        viewModel = viewModel,
        navController
      )
    }
    composable<AppScreens.AddInventory> {
      AddInventory(
        viewModel = viewModel,
        navController
      )
    }
    composable<AppScreens.ItemDetailScreen> {
      ItemDetailScreen(
        viewModel = viewModel,
        navController
      )
    }
  }




}