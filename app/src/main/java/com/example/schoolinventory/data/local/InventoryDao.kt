package com.example.schoolinventory.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.schoolinventory.data.model.Inventory
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryDao {

  @Query("SELECT * FROM inventory ORDER BY id DESC")
  fun getAllItems(): Flow<List<Inventory>>

  @Query("SELECT * FROM inventory WHERE id = :id")
  suspend fun getItemById(id: Int): Inventory

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertItem(item: Inventory)

  @Update
  suspend fun updateItem(item: Inventory)

  @Delete
  suspend fun deleteItem(item: Inventory)

  @Query("DELETE FROM inventory")
  suspend fun deleteAllItems()

}