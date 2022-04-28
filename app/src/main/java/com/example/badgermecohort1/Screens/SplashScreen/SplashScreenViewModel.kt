package com.example.badgermecohort1.Screens.SplashScreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.badgermecohort1.repositories.LoginRepository
import com.example.badgermecohort1.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    val userSignedIn = mutableStateOf<Boolean?>(null);
    val isLoading = mutableStateOf<Boolean>(false);

    init {
        Log.d("Splash screen", "Being created!")
        viewModelScope.launch(Dispatchers.IO) {
             val userEmail = loginRepository.getUserEmail()

            if (userEmail != null) {
                Log.d("SplashScreenViewModel", "User signed in")
                val usersResponse = userRepository.getUsersByEmail(userEmail);

//                usersResponse.enqueue(object : Callback<List<User>> {
//                    override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
//                        if(response?.body() != null) {
//                            Log.d("SplashScreenViewModel", response.body()!!.toString())
//                        }
//                    }
//                    override fun onFailure(call: Call<List<User>>, t: Throwable) {
//                        TODO("Not yet implemented")
//                        Log.d("SplashScreenViewModel", "Failed")
//                    }
//                })
//                userSignedIn.value = true
            } else {
                userSignedIn.value = false
            }
        }
    }

    fun setLoading(loadingState: Boolean) {
        isLoading.value = loadingState
    }
}