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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tmpsolutions.ApplicationScreen
import com.tmpsolutions.R
import com.tmpsolutions.domain.model.AquariumDomain
import com.tmpsolutions.ui.DesignUtils.AddButton
import com.tmpsolutions.ui.DesignUtils.HeaderBox
import com.tmpsolutions.ui.theme.TextStyles
import java.util.Date

@Composable
fun MainScreen(
    Aquariums: List<AquariumDomain>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        UserArea(Modifier)
        LazyColumn (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            items(items = Aquariums) {
                AquariumPreview(Aquarium = it)
            }
        }
        AddButton({ })
    }
}

@Composable
fun UserArea(modifier: Modifier = Modifier) {
    HeaderBox(title = "Welcome, ####"){
        Box(
            modifier
                .fillMaxSize()
                .padding(6.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "",
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
                Text(
                    text = Aquarium.name.ifEmpty { "Aquarium" },
                    fontWeight = FontWeight.Bold,
                    style = TextStyles.shadowTextStyle
                )
                Text(
                    text = "Habitantes: ${Aquarium.Animals.size}",
                    style = TextStyles.shadowTextStyle
                )
            }
        }
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