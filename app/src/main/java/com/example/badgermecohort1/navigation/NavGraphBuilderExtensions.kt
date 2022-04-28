package com.example.badgermecohort1.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.addTopLevel(
    navController: NavController
) {
    navigation(route = Screen.Splash.route, startDestination = Screen.Splash.route){
        composable(Screen.Splash.route) {
            Screen.Splash
        }
    }
}