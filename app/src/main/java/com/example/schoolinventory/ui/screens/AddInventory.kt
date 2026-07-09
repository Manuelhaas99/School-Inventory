package com.example.schoolinventory.ui.screens

import android.annotation.SuppressLint
import android.app.Activity
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Notes
import androidx.compose.material.icons.rounded.Sell
import androidx.compose.material.icons.rounded.Tag
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.schoolinventory.ui.components.ImagePickerButton
import com.example.schoolinventory.ui.components.InventoryTextField
import com.example.schoolinventory.ui.components.PrimaryButton
import com.example.schoolinventory.ui.components.QuantityStepper
import com.example.schoolinventory.ui.components.StateSelector
import com.example.schoolinventory.viewmodel.InventoryViewModel
import java.io.File

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddInventory(
  viewModel: InventoryViewModel = viewModel(),
  navController: NavController,
) {
  val uiState by viewModel.uiState.collectAsState()
  val context = LocalContext.current

  var photoUri by remember { mutableStateOf<Uri?>(null) }

  val cameraLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.TakePicture()
  ) { success ->
    if (success && photoUri != null) {
      viewModel.onImageCapture(photoUri!!)
    }
  }

  fun launchCamera() {
    val photoFile = File(
      context.externalCacheDir,
      "photo_${System.currentTimeMillis()}.jpg"
    )
    val uri = FileProvider.getUriForFile(
      context,
      "${context.packageName}.fileprovider",
      photoFile
    )
    photoUri = uri
    cameraLauncher.launch(uri)
  }

  Scaffold(
    containerColor = MaterialTheme.colorScheme.background,
    topBar = {
      TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = MaterialTheme.colorScheme.background
        ),
        navigationIcon = {
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
              "INVENTARIO",
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
        onClick = {
          viewModel.saveItem()
          navController.popBackStack()
        },
        text = "Guardar",
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

      InventoryTextField(
        value = uiState.description,
        onValueChange = { newText ->
          viewModel.onDescriptionChange(newText)
        },
        label = "Descripción",
        placeholder = "What is this item?",
        minLines = 2
      )

      QuantityStepper(
        quantity = uiState.quantity,
        onIncrement = { viewModel.increment() },
        onDecrement = { viewModel.decrement() }
      )

      InventoryTextField(
        value = uiState.brand,
        onValueChange = { newBrand ->
          viewModel.onBrandChange(newBrand)
        },
        label = "Marca",
        placeholder = "Fabricante",
        singleLine = true,
        trailingIcon = {
          Icon(
            Icons.Rounded.Sell,
            null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }
      )

      StateSelector(
        actualState = uiState.state,
        onSelectedState = { newState ->
          viewModel.onStateChange(newState)
        }
      )

      InventoryTextField(
        value = uiState.serie,
        onValueChange = { newSerie ->
          viewModel.onSeriesChange(newSerie)
        },
        label = "Serie",
        placeholder = "Numero de serie",
        singleLine = true,
        trailingIcon = {
          Icon(
            Icons.Rounded.Tag,
            null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }
      )

      InventoryTextField(
        value = uiState.observation,
        onValueChange = { newObservation ->
          viewModel.onObservationChange(newObservation)
        },
        label = "Observaciones",
        placeholder = "Notas u observaciones",
        minLines = 2,
        trailingIcon = {
          Icon(
            Icons.Rounded.Notes,
            null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }
      )
      Spacer(Modifier.height(8.dp))

      ImagePickerButton(
        imagePath = uiState.imagePath,
        onCameraClick = { launchCamera() },
      )
    }
  }
}