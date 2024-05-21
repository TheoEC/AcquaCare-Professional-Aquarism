package com.TMPSolutions.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.TMPSolutions.R

class LoginScreen {
}

@Preview(showBackground = true)
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.light_background)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TopCircles(
            modifier = Modifier
        )

        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
//            fontFamily = FontFamily.Resolver
        )
    }
}