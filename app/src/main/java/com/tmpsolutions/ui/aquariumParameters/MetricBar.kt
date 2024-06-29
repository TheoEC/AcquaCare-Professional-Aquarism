package com.tmpsolutions.ui.aquariumParameters

import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tmpsolutions.R

@Composable
fun MetricBar(@FloatRange(from = 0.0, to = 1.0) measuementValue: Float) {
    Box(
        modifier = Modifier
            .height(5.dp),
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize(),
            backgroundColor = colorResource(id = R.color.Metric_Red),
            elevation = 0.dp
        ) {

        }
        Card(
            modifier = Modifier
                .fillMaxWidth(measuementValue)
                .fillMaxHeight(),
            backgroundColor = colorResource(id = R.color.Metric_Green),
            elevation = 0.dp
        ) {

        }
    }
}

@Preview
@Composable
fun TestMetricBar() {
    MetricBar(.7f)
}