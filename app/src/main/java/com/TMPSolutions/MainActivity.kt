package com.TMPSolutions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.TMPSolutions.mapper.toDp
import com.TMPSolutions.ui.MainScreen
import com.TMPSolutions.ui.navigation.Navigation
import com.TMPSolutions.ui.theme.MyApplicationTheme
import com.TMPSolutions.ui.theme.Typography

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ApplicationScreen.Width = applicationContext.resources.displayMetrics.widthPixels.toDp(applicationContext)
        ApplicationScreen.Height = applicationContext.resources.displayMetrics.heightPixels.toDp(applicationContext)
        getActionBar()?.hide()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent{
            MyApplicationTheme {
                Navigation()
            }
        }
        getActionBar()?.hide()
    }
}

object ApplicationScreen{
    var Width: Dp = 393.dp
    var Height: Dp = 873.dp
}
