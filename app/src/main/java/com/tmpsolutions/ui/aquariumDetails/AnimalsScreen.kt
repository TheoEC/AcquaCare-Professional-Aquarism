package com.tmpsolutions.ui.aquariumDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tmpsolutions.domain.model.AquariumDomain
import com.tmpsolutions.ui.designUtils.AddButton
import com.tmpsolutions.ui.designUtils.BackgroundDesign

@Composable
fun AnimalsScreen(aquarium: AquariumDomain) {
    BackgroundDesign(
        title = aquarium.name
    ) {
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .height(60.dp)
            
        )  {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = "",
                    onValueChange = {},
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
    //                        focusedIndicatorColor = Color.Transparent,
    //                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .padding(vertical = 15.dp)
                        .fillMaxWidth(.9f)
                )
            }
        }
        AddButton {

        }
    }
}