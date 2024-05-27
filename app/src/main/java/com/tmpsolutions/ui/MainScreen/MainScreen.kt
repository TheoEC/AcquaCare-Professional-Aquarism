package com.tmpsolutions.ui.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tmpsolutions.ApplicationScreen
import com.tmpsolutions.R
import com.tmpsolutions.domain.model.Aquarium
import com.tmpsolutions.domain.model.AquariumDomain
import com.tmpsolutions.ui.TopCircles
import java.util.Date

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    Aquariums: List<AquariumDomain>
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        UserArea(modifier)
        LazyColumn (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            items(items = Aquariums) {
                AquariumPreview(Aquarium = it)
            }
        }
        AddAquariumButton()
    }
}

@Composable
fun UserArea(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(.25f)
            .background(colorResource(id = R.color.user_area_background))
    ){

        TopCircles(
            modifier.align(Alignment.TopStart),
            tint = R.color.top_white_circle
        )

        Box(
            modifier
                .fillMaxSize()
                .padding(6.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Welcome, ####",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

            TextButton(
                onClick = {  },
                modifier = modifier
                    .size(ApplicationScreen.Width / 10)
                    .padding(0.dp)
                    .align(Alignment.BottomStart)
                    .background(Color.Transparent),
                contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 0.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun AquariumPreview(Aquarium: AquariumDomain) {
    Card(
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(8.dp)
            .height(100.dp),
        elevation = 8.dp
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_aquarium),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 16.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                ShadedText(
                    text = Aquarium.name.ifEmpty { "Aquarium" },
                    fontWeight = FontWeight.Bold
                )
                ShadedText(text = "Habitantes: ${Aquarium.Animals.size}")
            }
        }
    }
}

@Composable
fun ShadedText(text: String, modifier: Modifier = Modifier, elevation: Int = 1, fontWeight: FontWeight = FontWeight.Normal) {
    Text(
        text = text,
        color = Color.Black,
        fontWeight = fontWeight,
        style = LocalTextStyle.current.copy(
            shadow = Shadow(
                color = Color.Gray,
                offset = Offset(2f, 4f),
                blurRadius = 5f
            )
        )
    )
}

@Composable
fun AddAquariumButton() {
    FloatingActionButton(
        onClick = {}
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

@Preview
@Composable
fun testCard(modifier: Modifier = Modifier) {
    val lstAquariums: MutableList<AquariumDomain> = mutableListOf(
        AquariumDomain(
            0,
            "",
            false,
            Date(),
            Date(),
            emptyList(),
            0,
            0,
            0,
            0f
        )
    )
    MainScreen(Aquariums = lstAquariums)
}