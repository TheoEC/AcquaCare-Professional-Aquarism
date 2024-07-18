package com.tmpsolutions.ui.aquariumParameters

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tmpsolutions.R
import com.tmpsolutions.domain.model.parameters.AquariumParameter
import com.tmpsolutions.ui.designUtils.AddButton
import com.tmpsolutions.ui.designUtils.BackgroundDesign
import com.tmpsolutions.ui.designUtils.CloseButton
import com.tmpsolutions.ui.designUtils.Loader

@Composable
fun ParametersScreen(viewModel: ParametersViewModel) {
    BackgroundDesign(
        title = "Parametros"
    ){
        val state = viewModel.state.collectAsState(initial = ParameterState.Loading)

        when(state.value){
            is ParameterState.Error -> Log.e("ParamScreen", (state.value as ParameterState.Error).message)
            ParameterState.Loading -> Loader()
            is ParameterState.Success ->
                ListParameters(viewModel)
        }
    }
}

@Composable
fun ListParameters(viewModel: ParametersViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var showAddScreen by remember {
            mutableStateOf(false)
        }

        LazyColumn(
            modifier = Modifier.padding(vertical = 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            if (showAddScreen) {
                items(items = viewModel.getMissingParameterTypes()) { parameterType ->
                    AddParameterCard(
                        parameter = parameterType,
                        addAquariumParameter = viewModel::addAquariumParameter
                    )
                }

                item {
                    CloseButton {
                        showAddScreen = false
                    }
                }
            } else {
                items(items = viewModel.aquariumParameters) { parameter ->
                    ParameterCard(
                        parameter = parameter,
                    )
                }

                item {
                    AddButton {
                        showAddScreen = true
                    }
                }
            }
        }




    }
}