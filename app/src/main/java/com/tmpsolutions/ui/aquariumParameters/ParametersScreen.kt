package com.tmpsolutions.ui.aquariumParameters

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.tmpsolutions.domain.model.parameters.AquariumParameter
import com.tmpsolutions.ui.designUtils.AddButton
import com.tmpsolutions.ui.designUtils.BackgroundDesign
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
    Column {
        var showAddScreen by remember {
            mutableStateOf(false)
        }

        Box {
            LazyColumn {
                items(items = viewModel.aquariumParameters) { parameter ->
                    ParameterCard(
                        parameter = parameter,
                    )
                }
            }
            if (showAddScreen) {
                AddParameterScreen(
                    viewModel = viewModel,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                )
            }
        }
        AddButton {
            showAddScreen = true
        }
    }
}