package com.example.schoolinventory.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.schoolinventory.R

val provider = GoogleFont.Provider(
  providerAuthority = "com.google.android.gms.fonts",
  providerPackage = "com.google.android.gms",
  certificates = R.array.com_google_android_gms_fonts_certs,
)

val nunitoFont = GoogleFont("Nunito")

val NunitoFontFamily = FontFamily(
  Font(googleFont = nunitoFont, fontProvider = provider, weight = FontWeight.Normal),
  Font(googleFont = nunitoFont, fontProvider = provider, weight = FontWeight.Bold),
)

val AppTypography = Typography(
  headlineMedium = TextStyle(
    fontFamily = NunitoFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 28.sp,
  ),
  headlineLarge = TextStyle(
    fontFamily = NunitoFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 32.sp,
  ),
  titleMedium = TextStyle(
    fontFamily = NunitoFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
  ),
  bodyLarge = TextStyle(
    fontFamily = NunitoFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
  ),
  bodySmall = TextStyle(
    fontFamily = NunitoFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
  ),
  labelSmall = TextStyle(
    fontFamily = NunitoFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 11.sp,
  ),
)