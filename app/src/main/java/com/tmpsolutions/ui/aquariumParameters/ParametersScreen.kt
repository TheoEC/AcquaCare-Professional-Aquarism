package com.tmpsolutions.ui.aquariumParameters

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
            is ParameterState.Success -> ListParameters((state.value as ParameterState.Success).parameters)
        }
    }
}

@Composable
fun ListParameters(parameters : List<AquariumParameter>) {
    if (parameters.isEmpty()) {
        AddButton {

        }
    }
    else {
        LazyColumn {
            items(items = parameters) { parameter ->
                ParameterCard(
                    parameterType = parameter.type,
                )
            }
        }
    }
}