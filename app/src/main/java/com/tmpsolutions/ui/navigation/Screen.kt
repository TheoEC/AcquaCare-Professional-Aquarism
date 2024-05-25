package com.tmpsolutions.ui.navigation

sealed class Screen(val route: String) {
    object WelcomeScreen : Screen("welcome")
    object LoginScreen : Screen("login")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}