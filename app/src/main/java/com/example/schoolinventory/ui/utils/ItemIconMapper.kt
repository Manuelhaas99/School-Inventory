package com.example.schoolinventory.ui.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

fun getItemIcon(description: String): ImageVector {
  val nameLower = description.lowercase()
  return when {
    nameLower.contains("microscope") || nameLower.contains("lab") -> Icons.Outlined.Biotech
    nameLower.contains("laptop") || nameLower.contains("chromebook") -> Icons.Outlined.LaptopChromebook
    nameLower.contains("computer") || nameLower.contains("pc") -> Icons.Outlined.Computer
    nameLower.contains("chair") -> Icons.Outlined.Chair
    nameLower.contains("desk") -> Icons.Outlined.Desk
    nameLower.contains("guitar") || nameLower.contains("music") -> Icons.Outlined.MusicNote
    nameLower.contains("ball") || nameLower.contains("soccer") -> Icons.Outlined.SportsSoccer
    nameLower.contains("book") || nameLower.contains("library") -> Icons.Outlined.MenuBook
    nameLower.contains("phone") -> Icons.Outlined.PhoneAndroid
    nameLower.contains("tablet") -> Icons.Outlined.TabletAndroid
    nameLower.contains("camera") -> Icons.Outlined.PhotoCamera
    nameLower.contains("printer") -> Icons.Outlined.Print
    nameLower.contains("projector") -> Icons.Outlined.Videocam
    else -> Icons.Outlined.Inventory2
  }
}