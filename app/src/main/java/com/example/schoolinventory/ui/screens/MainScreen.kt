package com.example.schoolinventory.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.schoolinventory.ui.components.ExtendedFab
import com.example.schoolinventory.ui.components.InventoryCard
import com.example.schoolinventory.viewmodel.InventoryViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
  viewModel: InventoryViewModel = viewModel(),
) {
  Scaffold(
    floatingActionButton = {
      ExtendedFab(
        onClick = {}
      )
    }

  ) { innerPadding ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding),
    ) {
      items(20) { cards ->
        InventoryCard()
      }
    }
  }
}