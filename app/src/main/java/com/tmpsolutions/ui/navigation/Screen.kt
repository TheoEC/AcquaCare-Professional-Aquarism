package com.tmpsolutions.ui.navigation

sealed class Screen(val route: String) {
    data object WelcomeScreen : Screen("welcome")
    data object LoginScreen : Screen("login")
    data object MainScreen : Screen("main")
    data object AquariumDetailScreen : Screen("aquarium_detail")
    data object AquariumParametersScreen : Screen("parameters")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}