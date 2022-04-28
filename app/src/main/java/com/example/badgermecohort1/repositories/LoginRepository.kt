package com.example.badgermecohort1.repositories

import android.content.Context
import android.content.Intent
import com.example.badgermecohort1.auth.getGoogleLoginAuth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.concurrent.ExecutionException

class LoginRepository(@ApplicationContext context : Context) {

    private var googleClient: GoogleSignInClient = getGoogleLoginAuth(context)

    private suspend fun getUserAccount() : GoogleSignInAccount? {
        if(googleClient == null) return null

        val task: Task<GoogleSignInAccount> =
            googleClient.silentSignIn()

        try {
            return Tasks.await(task)
        } catch (e: ExecutionException) {
            return null
        }
    }

    suspend fun isUserSignedIn() : Boolean{
        return getUserAccount() != null
    }

    suspend fun getUserToken() : String? {
        return getUserAccount()?.idToken
    }

    suspend fun getUserEmail() : String? {
        return getUserAccount()?.email
    }

    fun getGoogleClientSignInIntent() : Intent {
        return googleClient.signInIntent
    }






}