package com.example.schoolinventory.ui.components





import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.example.schoolinventory.navigation.AppScreens

@Composable
fun ExtendedFab(
  onClick: () -> Unit,
  text: String,
  icon: ImageVector,
  modifier: Modifier = Modifier,
){
  ExtendedFloatingActionButton(
    onClick = onClick ,
    icon = { Icon(imageVector = icon, contentDescription = null) },
    text = { Text(text) },
    modifier = modifier,
  )
}