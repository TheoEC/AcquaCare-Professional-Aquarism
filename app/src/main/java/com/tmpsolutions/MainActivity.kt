package com.tmpsolutions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import android.view.WindowManager
import com.tmpsolutions.mapper.toDp
import com.tmpsolutions.ui.getNavigationBarHeight
import com.tmpsolutions.ui.navigation.Navigation
import com.tmpsolutions.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ApplicationScreen.Width = applicationContext.resources.displayMetrics.widthPixels.toDp(applicationContext)
        ApplicationScreen.Height = applicationContext.resources.displayMetrics.heightPixels.toDp(applicationContext)
        ApplicationScreen.NavigationBarHeight = getNavigationBarHeight(this).toDp(applicationContext)

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
    var NavigationBarHeight: Dp = 56.dp
}
