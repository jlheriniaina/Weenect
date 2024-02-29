package com.weenect.testweenect.application.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Primary = Color(0xFFFF5722)
val PrimaryDark = Color(0xFFb23c17)
val Accent = Color(0xFFFF784E)
val AccentLight = Color(0xFFffd6c9)


val LightGray = Color(0XFFFCFCFC)
val LightGray40 = Color(0xFFEAEAEA)
val MediumGray = Color(0XFF9C9C9C)
val DarkGray = Color(0xFF141414)

val ColorScheme.textColor : Color
    @Composable
    get() = if(isSystemInDarkTheme()) LightGray else DarkGray