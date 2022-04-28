package com.example.badgermecohort1.navigation

sealed class Screen(val route: String) {
    object Splash: Screen(route = "splash")
    object Login: Screen(route = "login")
    object Home: Screen(route = "home")
    object UserSetup: Screen(route = "userSetup")
}


