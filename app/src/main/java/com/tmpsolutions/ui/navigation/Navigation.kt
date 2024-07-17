package com.tmpsolutions.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tmpsolutions.domain.repository.ParametersRepository
import com.tmpsolutions.ui.aquariumDetails.AquariumDetailViewModel
import com.tmpsolutions.ui.aquariumDetails.AquariumDetailsScreen
import com.tmpsolutions.ui.LoginScreen
import com.tmpsolutions.ui.MainScreen.MainScreen
import com.tmpsolutions.ui.MainScreen.MainViewModel
import com.tmpsolutions.ui.WelcomeScreen
import com.tmpsolutions.ui.aquariumParameters.ParametersScreen
import com.tmpsolutions.ui.aquariumParameters.ParametersViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.context.GlobalContext.get
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.inject

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
                val viewModel: AquariumDetailViewModel = koinViewModel() {
                    parametersOf(aquariumID)
                }

                AquariumDetailsScreen(
                    navController = navController,
                    viewModel = viewModel
                )
            } else {
                //TODO return and show error dialog
            }

        }

        composable(
            route = Screen.AquariumParametersScreen.route + "/{aquariumID}",
            arguments = listOf(
                navArgument("aquariumID") {
                    type = NavType.IntType
                    nullable = false
                }
            )
        ) { backStackEntry ->
            val aquariumID = backStackEntry.arguments?.getInt("aquariumID")
            val viewModel : ParametersViewModel = koinViewModel() {
                parametersOf(aquariumID)
            }
            ParametersScreen(viewModel)
        }
    }
}
