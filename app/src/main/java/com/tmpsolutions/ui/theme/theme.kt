package com.tmpsolutions.ui.theme

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.tmpsolutions.R

@Composable
fun MyApplicationTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = Typography,
        content = content
    )

}