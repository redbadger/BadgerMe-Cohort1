package com.example.badgermecohort1.Screens.UserSetupScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.badgermecohort1.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserSetupViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val TAG = UserSetupViewModel::class.qualifiedName

    val mutableList = mutableListOf<String>()

    fun addUserInterests(navController: NavController){
        Log.d(TAG, "Adding user interests: $mutableList")
        navController.navigate("user_profile")
    }


}