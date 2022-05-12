package com.example.badgermecohort1.Screens.LoginScreen

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
) : ViewModel() {
    private val TAG = UserProfileViewModel::class.qualifiedName

    fun navigateToMainScreen(navController: NavController){
        navController.navigate("main_screen")
    }
}