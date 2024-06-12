package com.tmpsolutions.ui.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tmpsolutions.R
import com.tmpsolutions.domain.model.AquariumDomain
import com.tmpsolutions.ui.DesignUtils.AddButton
import com.tmpsolutions.ui.theme.TextStyles

@Composable
fun AquariumCard(aquarium: AquariumDomain) {
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
                    text = aquarium.name.ifEmpty { "Aquarium" },
                    fontWeight = FontWeight.Bold,
                    style = TextStyles.shadowTextStyle
                )
                Text(
                    text = "Habitantes: ${aquarium.habitants.size}",
                    style = TextStyles.shadowTextStyle
                )
            }
        }
    }
}

@Composable
fun AquariumCardList(aquariums : List<AquariumDomain>) {
    LazyColumn (
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        items(items = aquariums) {
            AquariumCard(aquarium = it)
        }
    }

}