package com.tmpsolutions.ui.aquariumParameters

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.tmpsolutions.R
import com.tmpsolutions.domain.model.parameters.ParameterType

@Composable
fun AddParameterScreen(
    viewModel: ParametersViewModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(.8f)
    ) {
        LazyColumn {

        }
    }
}

@Composable
fun AddParameterCard(parameter: ParameterType, addAquariumParameter : (id: Int) -> Unit) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = parameter.getParameterName(),
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 5.dp)
        )
        Button(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 5.dp),
            onClick = { addAquariumParameter(parameter.id) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.Metric_Green)
            )
        ) {
            Text(text = "Adicionar")
        }
    }
}