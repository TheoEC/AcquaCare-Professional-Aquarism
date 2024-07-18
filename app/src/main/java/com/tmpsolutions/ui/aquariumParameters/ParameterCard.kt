package com.tmpsolutions.ui.aquariumParameters

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tmpsolutions.domain.model.parameters.AquariumParameterTypeID
import com.tmpsolutions.domain.model.parameters.ParameterTypeDomain
import android.util.TypedValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.google.android.material.R.attr.cardBackgroundColor
import com.tmpsolutions.domain.model.parameters.AquariumParameter

@Composable
fun ParameterCard(parameter: AquariumParameter) {
    val context = LocalContext.current
    val typedValue = TypedValue()
    context.theme.resolveAttribute(cardBackgroundColor, typedValue, true)
    val color = typedValue.data
    Card(
        modifier = Modifier
            .fillMaxWidth(.9f)
            .height(110.dp),
        backgroundColor = Color(color)
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Column (
                Modifier.fillMaxWidth()
            ) {
                Text(
                    text = parameter.type!!.getParameterName(), //TODO Protection with missing advice
                    fontSize = 20.sp
                )
                Text(
                    text = "Oct 8 - 14",
                    fontSize = 10.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "0.25 ppm",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(.7f)
                            .align(Alignment.CenterEnd)
                    ) {
                        MetricBar(measuementValue = .7f)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = false,
    device = "spec:id=reference_phone,shape=Normal,width=411,height=891,unit=dp,dpi=420"
)
@Composable
fun PreviewTest(modifier: Modifier = Modifier) {
    val ph = ParameterTypeDomain(
        id = AquariumParameterTypeID.PH,
        name = "pH",
        metric = ""
    )

    ParameterCard(
        parameter = AquariumParameter(
            type = ph,
            aquariumID = -1,
            lastMeasurement = null
        )
    )
}