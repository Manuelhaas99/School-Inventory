package com.example.schoolinventory.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.schoolinventory.data.model.Inventory


@Database(
  entities = [Inventory::class],
  version = 2,
  exportSchema = false
)
abstract class InventoryDatabase : RoomDatabase() {
  abstract fun inventoryDao(): InventoryDao

  companion object {
    @Volatile
    private var INSTANCE: InventoryDatabase? = null

    fun getDatabase(context: Context): InventoryDatabase {
      return INSTANCE ?: synchronized(this) {
        val instance = Room.databaseBuilder(
          context.applicationContext,
          InventoryDatabase::class.java,
          "inventory_database"
        )
          .fallbackToDestructiveMigration()
          .build()
        INSTANCE = instance
        instance
      }
    }
  }
}
