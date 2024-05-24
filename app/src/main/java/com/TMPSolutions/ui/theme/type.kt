package com.TMPSolutions.ui.theme

import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.TMPSolutions.R


private val myCustomFont = FontFamily(
    Font(R.font.poppins),
)


val Typography = Typography(
    defaultFontFamily = myCustomFont,
)