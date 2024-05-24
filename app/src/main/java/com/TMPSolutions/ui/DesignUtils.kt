package com.TMPSolutions.ui

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.TMPSolutions.ApplicationScreen
import com.TMPSolutions.R

@Preview
@Composable
fun TopCircles(
    modifier: Modifier = Modifier,
    tint: Int = R.color.top_blue_circle
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
//            .fillMaxHeight(.25f)
    ){
        val widthInDP = ApplicationScreen.Width
        Image(
            painter = painterResource(id = R.drawable.img_user_area_background_foreground),
            contentDescription = null,
            modifier = modifier
                .width(ApplicationScreen.Width * .45f)
                .height(ApplicationScreen.Width * .45f),
            alignment = Alignment.TopStart,
            colorFilter = ColorFilter.tint(colorResource(tint))
        )
    }
}