package com.example.badgermecohort1.Screens.LoginScreen

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.badgermecohort1.repositories.LoginRepository
import com.example.badgermecohort1.repositories.UserRepository
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    fun getUserAccount(result: ActivityResult) : GoogleSignInAccount? {
            Log.d("LogInPage", result.resultCode.toString())
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                Log.d("LogInPage", "Result.data")

                if (result.data != null) {
                    val task: Task<GoogleSignInAccount> =
                        GoogleSignIn.getSignedInAccountFromIntent(intent)
                    val result = task?.getResult()

                    if (result != null) {
                        Log.d("Log in page", result.idToken)
                        return result
                    }
                }
            }
            Log.d("Log in page", "No task result")
            return null
        }

    fun launchGoogleClientSignIn() : Intent {
        return loginRepository.getGoogleClientSignInIntent()
    }

    //ToDo: Change Function name
    fun navigateUser(
        userEmail: String,
        navController: NavController,
        composableScope: CoroutineScope){
        composableScope.launch(Dispatchers.IO) {
            val usersResponse = userRepository.getUsersByEmail(userEmail);

           if(usersResponse != null && usersResponse.isNotEmpty()) {
                Log.d("SplashScreenViewModel", "User exists")
                navController.navigate("main_screen")
            } else {
                Log.d("SplashScreenViewModel", "User does not exist")
                navController.navigate("user_setup")
            }
        }
    }


    }