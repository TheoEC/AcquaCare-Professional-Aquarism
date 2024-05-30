package com.tmpsolutions.ui.DesignUtils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tmpsolutions.ApplicationScreen
import com.tmpsolutions.R

@Preview
@Composable
fun HeaderBox(
    modifier: Modifier = Modifier,
    tint: Int = R.color.top_blue_circle,
    paintBackground: Boolean = true,
    title: String = "",
    content: @Composable BoxScope.() -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.25f)
            .background(colorResource(id = R.color.user_area_background))
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_user_area_background_foreground),
            contentDescription = null,
            modifier = modifier
                .width(ApplicationScreen.Width * .45f)
                .height(ApplicationScreen.Width * .45f),
            alignment = Alignment.TopStart,
            colorFilter = ColorFilter.tint(colorResource(tint))
        )

        Text(
            text = title,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxHeight(.35f),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        content()
    }
}

@Composable
fun BackgroundDesign(
    modifier: Modifier = Modifier,
    tint: Int = R.color.top_blue_circle,
    paintBackground: Boolean = true,
    title: String = "",
    header: @Composable BoxScope.() -> Unit = {},
    content: @Composable ColumnScope.() -> Unit = {}
) {
    Column {
        HeaderBox(modifier, tint, paintBackground, title, header)

        Column (
            modifier = Modifier
                .background(colorResource(id = R.color.light_background))
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            content()
        }
    }
}

@Composable
fun AddButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = null,
            modifier = Modifier
                .width(65.dp)
                .height(65.dp)
        )
    }
}