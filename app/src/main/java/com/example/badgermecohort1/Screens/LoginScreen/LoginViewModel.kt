package com.example.badgermecohort1.Screens.LoginScreen

import android.app.Activity
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
    private val TAG = LoginViewModel::class.qualifiedName

    fun getUserAccount(result: ActivityResult) : GoogleSignInAccount? {
            Log.d(TAG, result.resultCode.toString())
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data

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
            Log.d(TAG, "No task result")
            return null
        }

    fun navigateUser(
        userEmail: String,
        navController: NavController,
        composableScope: CoroutineScope){
        composableScope.launch(Dispatchers.IO) {
            val usersResponse = userRepository.getUsersByEmail(userEmail);

            if(usersResponse != null && usersResponse.isNotEmpty()) {
                Log.d(TAG, "User exists")
                navController.navigate("main_screen")
            } else {
                Log.d(TAG, "User does not exist")
                navController.navigate("user_setup")
            }
        }
    }
}