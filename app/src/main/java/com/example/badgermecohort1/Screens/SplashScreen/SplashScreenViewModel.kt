package com.example.badgermecohort1.Screens.SplashScreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.badgermecohort1.repositories.LoginRepository
import com.example.badgermecohort1.repositories.UserRepository
import com.example.badgermecohort1.repositories.UserResponseError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    private val TAG = SplashScreenViewModel::class.qualifiedName

    val userSignedIn = mutableStateOf<Boolean?>(null);
    val userExists = mutableStateOf<Boolean?>(null);
    val isLoading = mutableStateOf<Boolean>(false);

    init {
        viewModelScope.launch(Dispatchers.IO) {
             val userEmail = loginRepository.getUserEmail()

            if (userEmail != null) {
                Log.d(TAG, "User signed in: $userEmail")

                val usersResponse = userRepository.getUserByEmail(userEmail);
                if (usersResponse.user != null) {
                    Log.d(TAG, "User exists")
                    userExists.value = true;
                } else if (usersResponse.error == UserResponseError.UserDoesNotExist) {
                    Log.d(TAG, "User does not exist")
                    userExists.value = false;
                } else if (usersResponse.error == UserResponseError.InvalidToken || usersResponse.error == UserResponseError.NotLoggedIn) {
                    Log.d(TAG, "Invalid token or not logged in")
                    userSignedIn.value = false
                }
                // TODO: add better handling for other error types
                Log.d(TAG, "Some other error: ${UserResponseError.OtherError}")
                userSignedIn.value = false
            } else {
                userSignedIn.value = false
            }
        }
    }

    fun setLoading(loadingState: Boolean) {
        isLoading.value = loadingState
    }
}