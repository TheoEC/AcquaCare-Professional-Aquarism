package com.TMPSolutions.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.TMPSolutions.R

@Preview(showBackground = true)
@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.light_background)),
            horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TopCircles()

        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(.3f)
                .fillMaxHeight(.25f)
        )

        Text(
            text = stringResource(id = R.string.welcome_title),
            modifier = Modifier
                .padding(top = 80.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text =  stringResource(id = R.string.welcome_text),
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(.50f),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
        )

        Box (
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 32.dp)
        ){
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .background(colorResource(id = R.color.light_background))
                    .fillMaxWidth()
                    .height(60.dp)
                    .align(Alignment.BottomCenter),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.user_area_background))
            ) {
                Text(
                    text = stringResource(id = R.string.start),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.light_background)
                )
            }
        }


    }
}