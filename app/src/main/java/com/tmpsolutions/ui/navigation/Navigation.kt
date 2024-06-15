package com.tmpsolutions.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tmpsolutions.ui.AquariumDetails.AquariumDetailViewModel
import com.tmpsolutions.ui.AquariumDetails.AquariumDetailsScreen
import com.tmpsolutions.ui.LoginScreen
import com.tmpsolutions.ui.MainScreen.MainScreen
import com.tmpsolutions.ui.MainScreen.MainViewModel
import com.tmpsolutions.ui.WelcomeScreen

@Composable
fun Navigation(context: Context, mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route) {
        composable(route = Screen.WelcomeScreen.route) {
            WelcomeScreen(navController = navController)
        }

        composable(
            route = Screen.LoginScreen.route + "/{firstlogin}",
            arguments = listOf(
                navArgument("firstlogin") {
                    type = NavType.BoolType
                    defaultValue = true
                    nullable = false
                }
            )
        ) { _ ->
            LoginScreen(navController)
        }

        composable(route = Screen.MainScreen.route) {
            MainScreen(
                navController = navController,
                mainViewModel = mainViewModel,)
        }

        composable(
            route = Screen.AquariumDetailScreen.route + "/{aquariumID}",
            arguments = listOf(
                navArgument("aquariumID") {
                    type = NavType.IntType
                    nullable = false
                }
            )
        ) { backStackEntry ->
            val aquariumID = backStackEntry.arguments?.getInt("aquariumID")
            if (aquariumID != null) {
                val factory = AquariumDetailViewModel.Factory(context, aquariumID)
                val viewModel: AquariumDetailViewModel = viewModel(factory = factory)
                AquariumDetailsScreen(viewModel)
            } else {
                //TODO return and show error dialog
            }

        }
    }
}
