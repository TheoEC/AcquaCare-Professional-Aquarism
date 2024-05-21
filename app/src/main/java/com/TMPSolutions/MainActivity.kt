package com.TMPSolutions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.TMPSolutions.mapper.toDp
import com.TMPSolutions.ui.MainScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ApplicationScreen.Width = applicationContext.resources.displayMetrics.widthPixels.toDp(applicationContext)
        ApplicationScreen.Height = applicationContext.resources.displayMetrics.heightPixels.toDp(applicationContext)
        setContent{
            MainScreen()
        }
    }
}

object ApplicationScreen{
    var Width: Dp = 393.dp
    var Height: Dp = 873.dp
}
