package com.TMPSolutions.mapper

import android.content.Context
import androidx.compose.ui.unit.dp

fun Int.toDp(context: Context) = (this / context.resources.displayMetrics.density).dp