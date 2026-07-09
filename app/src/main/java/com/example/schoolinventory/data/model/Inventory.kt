package com.example.schoolinventory.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inventory")
data class Inventory(
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
  val description: String,
  val quantity: Int,
  val brand: String,
  val state: String,
  val serie: String,
  val observation: String,
  val imagePath: String? = null,
)