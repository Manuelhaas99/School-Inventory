package com.example.schoolinventory.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.PictureAsPdf
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Notes
import androidx.compose.material.icons.rounded.Sell
import androidx.compose.material.icons.rounded.Tag
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.schoolinventory.navigation.AppScreens
import com.example.schoolinventory.ui.components.InventoryTextField
import com.example.schoolinventory.ui.components.PrimaryButton
import com.example.schoolinventory.ui.components.QuantityStepper
import com.example.schoolinventory.ui.components.StateSelector
import com.example.schoolinventory.viewmodel.InventoryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddInventory(
  viewModel: InventoryViewModel = viewModel(),
  navController: NavController,
) {
  // 1. Estados simulados (Mock) para que la UI funcione sin base de datos aún
  var description by remember { mutableStateOf("") }
  var quantity by remember { mutableIntStateOf(0) }
  var brand by remember { mutableStateOf("") }
  var serie by remember { mutableStateOf("") }
  var observation by remember { mutableStateOf("") }

  Scaffold(
    containerColor = MaterialTheme.colorScheme.background,
    topBar = {
      TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = MaterialTheme.colorScheme.background
        ),
        navigationIcon = {
          // Ahora el botón de regresar funciona de verdad
          IconButton(onClick = { navController.popBackStack() }) {
            Icon(
              Icons.Rounded.ArrowBack,
              contentDescription = "Back",
              tint = MaterialTheme.colorScheme.onBackground
            )
          }
        },
        title = {
          Column {
            Text(
              "INVENTORY",
              color = MaterialTheme.colorScheme.onSurfaceVariant,
              fontSize = 12.sp,
              fontWeight = FontWeight.Medium,
              letterSpacing = 0.4.sp
            )
            Text(
              "New item",
              color = MaterialTheme.colorScheme.onBackground,
              fontSize = 22.sp,
              fontWeight = FontWeight.Bold
            )
          }
        },
      )
    },
    bottomBar = {
      PrimaryButton(
        onClick = {},
        text = "Save",
        icon = Icons.Outlined.Check,
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp),
      )
    }
  ) { pad ->
    Column(
      Modifier
        .padding(pad)
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(horizontal = 20.dp, vertical = 8.dp),
      verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {

      // Pasamos nuestras variables temporales a cada campo
      InventoryTextField(
        value = description,
        onValueChange = { description = it },
        label = "Description",
        placeholder = "What is this item?",
        minLines = 2
      )

      QuantityStepper(
        quantity = quantity,
        onQuantityChange = { quantity = it }
      )

      InventoryTextField(
        value = brand,
        onValueChange = { brand = it },
        label = "Brand",
        placeholder = "Manufacturer",
        singleLine = true,
        trailingIcon = { Icon(Icons.Rounded.Sell, null, tint = MaterialTheme.colorScheme.onSurfaceVariant) }
      )

      // Asumiendo que dejamos StateSelector sin parámetros en el paso anterior
      StateSelector()

      InventoryTextField(
        value = serie,
        onValueChange = { serie = it },
        label = "Serie",
        placeholder = "Serial number",
        singleLine = true,
        trailingIcon = { Icon(Icons.Rounded.Tag, null, tint = MaterialTheme.colorScheme.onSurfaceVariant) }
      )

      InventoryTextField(
        value = observation,
        onValueChange = { observation = it },
        label = "Observation",
        placeholder = "Notes or remarks",
        minLines = 2,
        trailingIcon = { Icon(Icons.Rounded.Notes, null, tint = MaterialTheme.colorScheme.onSurfaceVariant) }
      )

      Spacer(Modifier.height(8.dp))
    }
  }
}