package com.tmpsolutions.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.tmpsolutions.R


private val poppinsFont = FontFamily(
    Font(R.font.poppins),
)

val Typography = Typography(
    defaultFontFamily = poppinsFont,
)

object TextStyles {
    val shadowTextStyle = TextStyle(
        shadow = Shadow(
            color = Color.Gray,
            offset = Offset(2f, 4f),
            blurRadius = 5f
        )
    )
}
