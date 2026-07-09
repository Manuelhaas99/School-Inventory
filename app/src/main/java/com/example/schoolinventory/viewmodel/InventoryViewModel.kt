package com.example.schoolinventory.viewmodel

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewModelScope
import com.example.schoolinventory.data.local.InventoryDatabase
import com.example.schoolinventory.data.model.Inventory
import com.example.schoolinventory.data.model.ItemState
import com.example.schoolinventory.data.repository.InventoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.net.URI
import kotlin.collections.emptyList


class InventoryViewModel(application: Application) : AndroidViewModel(application) {

  private val repository: InventoryRepository

  private val _uiState = MutableStateFlow(InventoryUiState())
  val uiState: StateFlow<InventoryUiState> = _uiState.asStateFlow()

  private val _selectItem = MutableStateFlow<Inventory?>(null)
  val selectItem: StateFlow<Inventory?> = _selectItem.asStateFlow()

  data class InventoryUiState(
    val description: String = "",
    val quantity: Int = 0,
    val brand: String = "",
    val state: ItemState = ItemState.UNSELECTED,
    val serie: String = "",
    val observation: String = "",
    val imagePath: String? = null,
  )

  val items: StateFlow<List<Inventory>>

  init {
    val dao = InventoryDatabase.getDatabase(application).inventoryDao()
    repository = InventoryRepository(dao)

    items = repository.allItems
      .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
      )
  }

  fun saveItem() {
    viewModelScope.launch {
      repository.insertItem(
        Inventory(
          description = _uiState.value.description,
          quantity = _uiState.value.quantity,
          brand = _uiState.value.brand,
          state = _uiState.value.state.name,
          serie = _uiState.value.serie,
          observation = _uiState.value.observation,
          imagePath = _uiState.value.imagePath
        )
      )
      clearForm()
    }
  }

  fun deleteItem(item: Inventory) {
    viewModelScope.launch {
      repository.deleteItem(item)
    }
  }

  fun selectItem(item: Inventory) {
    _selectItem.value = item
  }

  fun clearForm() {
    _uiState.value = InventoryUiState()
  }

  fun onImageCapture(uri: Uri){
    _uiState.value = _uiState.value.copy(imagePath = uri.toString())
  }

  fun onDescriptionChange(value: String) {
    _uiState.value = _uiState.value.copy(description = value)
  }

  fun onBrandChange(value: String) {
    _uiState.value = _uiState.value.copy(brand = value)
  }

  fun onSeriesChange(value: String) {
    _uiState.value = _uiState.value.copy(serie = value)
  }

  fun onObservationChange(value: String) {
    _uiState.value = _uiState.value.copy(observation = value)
  }

  fun onStateChange(value: ItemState) {
    _uiState.value = _uiState.value.copy(state = value)
  }

  fun increment() {
    _uiState.value = _uiState.value.copy(quantity = _uiState.value.quantity + 1)
  }

  fun decrement() {
    if (_uiState.value.quantity > 0)
      _uiState.value = _uiState.value.copy(quantity = _uiState.value.quantity - 1)
  }
}
