package com.tmpsolutions.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tmpsolutions.ui.LoginScreen
import com.tmpsolutions.ui.MainScreen.MainScreen
import com.tmpsolutions.ui.WelcomeScreen

@Composable
fun Navigation() {
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
        ) {entry ->
            LoginScreen(navController)
        }

        composable(route = Screen.MainScreen.route) {
            MainScreen()
        }
    }
}
