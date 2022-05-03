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

interface LoginRepository {
    suspend fun getUserToken() : String?
    suspend fun getUserEmail() : String?
    fun getGoogleClientSignInIntent() : Intent
}

class LoginRepositoryImpl(@ApplicationContext context : Context): LoginRepository {

    private var googleClient: GoogleSignInClient = getGoogleLoginAuth(context)

    private fun getUserAccount() : GoogleSignInAccount? {
        if(googleClient == null) return null

        val task: Task<GoogleSignInAccount> =
            googleClient.silentSignIn()

        return try {
            Tasks.await(task)
        } catch (e: ExecutionException) {
            null
        }
    }

    override suspend fun getUserToken() : String? {
        return getUserAccount()?.idToken
    }

    override suspend fun getUserEmail() : String? {
        return getUserAccount()?.email
    }

    override fun getGoogleClientSignInIntent() : Intent {
        return googleClient.signInIntent
    }
}