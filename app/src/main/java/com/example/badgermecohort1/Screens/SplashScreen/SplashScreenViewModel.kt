package com.example.badgermecohort1.Screens.SplashScreen

import androidx.lifecycle.ViewModel
import com.example.badgermecohort1.repositories.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    fun isUserSignedIn(): Boolean {
        GlobalScope.launch {
             loginRepository.userSignedIn()
        }
    }


}