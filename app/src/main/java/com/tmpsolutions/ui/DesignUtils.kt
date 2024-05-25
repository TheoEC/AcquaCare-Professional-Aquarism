package com.tmpsolutions.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
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
import com.tmpsolutions.ApplicationScreen
import com.tmpsolutions.R

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