package com.TMPSolutions.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.TMPSolutions.R

@Composable
fun TopCircles(
    modifier: Modifier = Modifier,
    tint: Int = R.color.top_blue_circle
) {
        Image(
            painter = painterResource(id = R.drawable.img_user_area_background_foreground),
            contentDescription = null,
            modifier = modifier
                .fillMaxSize(.6f),
            alignment = Alignment.TopStart,
            colorFilter = ColorFilter.tint(colorResource(tint))
        )
//    }
}