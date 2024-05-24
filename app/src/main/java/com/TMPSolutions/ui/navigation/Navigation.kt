package com.TMPSolutions.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.TMPSolutions.ui.LoginScreen
import com.TMPSolutions.ui.WelcomeScreen

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
            LoginScreen()
        }
    }
}
