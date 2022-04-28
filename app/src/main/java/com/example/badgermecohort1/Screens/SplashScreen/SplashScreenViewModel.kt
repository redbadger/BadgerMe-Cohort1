package com.example.badgermecohort1.Screens.SplashScreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.badgermecohort1.repositories.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {
    val userSignedIn = mutableStateOf<Boolean?>(null);
    val isLoading = mutableStateOf<Boolean>(false);

    init {
        Log.d("Splash screen", "Being created!")
        viewModelScope.launch(Dispatchers.IO) {
             userSignedIn.value = loginRepository.userSignedIn()
        }
    }

    fun setLoading(loadingState: Boolean) {
        isLoading.value = loadingState
    }
}