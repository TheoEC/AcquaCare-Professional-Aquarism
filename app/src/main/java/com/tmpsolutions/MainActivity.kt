package com.tmpsolutions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import android.view.WindowManager
import androidx.activity.viewModels
import com.tmpsolutions.data.di.dataModule
import com.tmpsolutions.domain.di.aquariumModule
import com.tmpsolutions.mapper.toDp
import com.tmpsolutions.ui.MainScreen.MainViewModel
import com.tmpsolutions.ui.getNavigationBarHeight
import com.tmpsolutions.ui.navigation.Navigation
import com.tmpsolutions.ui.theme.MyApplicationTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {

    val mainViewModel : MainViewModel by viewModels {
        MainViewModel.Factory(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ApplicationScreen.Width = applicationContext.resources.displayMetrics.widthPixels.toDp(applicationContext)
        ApplicationScreen.Height = applicationContext.resources.displayMetrics.heightPixels.toDp(applicationContext)
        ApplicationScreen.NavigationBarHeight = getNavigationBarHeight(this).toDp(applicationContext)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    dataModule,
                    aquariumModule
                )
            )
        }

        setContent{
            MyApplicationTheme {
                Navigation(applicationContext, mainViewModel)
            }
        }
    }
}

object ApplicationScreen{
    var Width: Dp = 393.dp
    var Height: Dp = 873.dp
    var NavigationBarHeight: Dp = 56.dp
}
