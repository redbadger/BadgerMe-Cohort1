package com.example.badgermecohort1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.badgermecohort1.Screens.UserSetupScreen.userSetup
import com.google.android.gms.auth.api.signin.GoogleSignInClient

@Composable
fun navigation(googleClient: GoogleSignInClient?) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {

        composable("splash_screen") {
            splashScreenAnimate(navController)
        }
        composable("login_screen") {
            login(navController, googleClient)
        }
        composable("main_screen") {
            mainScreen(navController)
        }
        composable("user_setup") {
            userSetup(navController)
        }
    }
}