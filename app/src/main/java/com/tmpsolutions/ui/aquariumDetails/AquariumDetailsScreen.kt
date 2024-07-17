package com.tmpsolutions.ui.aquariumDetails

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tmpsolutions.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tmpsolutions.ui.designUtils.BackgroundDesign
import com.tmpsolutions.ui.navigation.Screen

@Composable
fun AquariumDetailsScreen(
    navController: NavHostController,
    viewModel: AquariumDetailViewModel
) {
    var title by remember { mutableStateOf("") }

    val state = viewModel.state.collectAsState(initial = AquariumDetailState.Loading)

    BackgroundDesign(title = title) {
        when(state.value) {
            is AquariumDetailState.Loading -> {
                title = "Loading"
            }
            is AquariumDetailState.Success -> {
                title = (state.value as AquariumDetailState.Success).aquarium.name
                FunctionalitiesList(navController, viewModel.aquariumID)
            }
            is AquariumDetailState.Error -> Log.e("AquariumDetailScreen", "ERROR")
        }
    }
}

@Composable
fun FunctionalitiesList(
    navController: NavHostController,
    aquariumID: Int
){
    val scrollSate = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(top = 10.dp)
            .verticalScroll(scrollSate)
    ) {
        ButtonCard(
            resourceId = R.drawable.ic_logo,
            title = "Animals",
            description = "Todos os animais do seu aquario estao salvos aqui.",
            onClick = {}
        )

        ButtonCard(
            resourceId = R.drawable.ic_ph,
            title = "Parametros",
            description = "Saiba a saúde do seu aquário através de todas as métricas salvas ",
            onClick = {
                navController.navigate(Screen.AquariumParametersScreen.route + "/${aquariumID}")
            }
        )

        ButtonCard(
            resourceId = R.drawable.ic_termometer,
            title = "Equipamentos",
            description = "Todos os seus equipamentos",
            onClick = {}
        )

        ButtonCard(
            resourceId = R.drawable.ic_calendar,
            title = "Calendario",
            description = "Planejamento e Registro de suas rotinas como almentção e outros",
            onClick = {}
        )

        ButtonCard(
            resourceId = R.drawable.ic_camera,
            title = "Imagens",
            description = "Imagens do seu aquario",
            onClick = {}
        )
    }
}

@Composable
fun ButtonCard(
    @DrawableRes resourceId: Int,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(.9f)
            .padding(8.dp)
            .height(100.dp)
            .clickable { onClick() },
        elevation = 8.dp,
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Image(
                painter = painterResource(resourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .fillMaxHeight(.9f)
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 16.dp)
            )
            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 9.dp, horizontal = 5.dp)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    lineHeight = 18.sp
                )
                Text(
                    text = description,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(bottom = 0.dp),
                    color = colorResource(id = R.color.card_description),
                    maxLines = 3
                )
            }
        }
    }
}