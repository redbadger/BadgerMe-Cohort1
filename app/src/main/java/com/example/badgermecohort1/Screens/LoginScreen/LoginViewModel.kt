package com.example.badgermecohort1.Screens.LoginScreen

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.lifecycle.ViewModel
import com.example.badgermecohort1.repositories.LoginRepository
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    fun isUserLoggedIn(result: ActivityResult) : Boolean{
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
                        return true
                    } else {
                        Log.d("Log in page", "No task result")
                        return false
                    }
                }
            }
            return false
        }

    fun launchGoogleClientSignIn() : Intent {
        return loginRepository.getGoogleClientSignInIntent()
    }


    }