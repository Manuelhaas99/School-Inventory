package com.example.schoolinventory.data.repository

import com.example.schoolinventory.data.local.InventoryDao
import com.example.schoolinventory.data.model.Inventory
import kotlinx.coroutines.flow.Flow

class InventoryRepository(private val dao: InventoryDao) {

  val allItems: Flow<List<Inventory>> = dao.getAllItems()

  suspend fun insertItem(item: Inventory) {
    dao.insertItem(item)
  }

  suspend fun updateItem(item: Inventory) {
    dao.updateItem(item)
  }

  suspend fun deleteItem(item: Inventory) {
    dao.deleteItem(item)
  }

  suspend fun getItemById(id: Int): Inventory {
    return dao.getItemById(id)
  }
}