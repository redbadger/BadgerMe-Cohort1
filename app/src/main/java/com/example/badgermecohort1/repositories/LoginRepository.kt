package com.example.badgermecohort1.repositories

import android.content.Context
import android.content.Intent
import com.example.badgermecohort1.auth.getGoogleLoginAuth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import dagger.hilt.android.qualifiers.ApplicationContext

class LoginRepository(@ApplicationContext context : Context) {

    private var googleClient: GoogleSignInClient = getGoogleLoginAuth(context)

    suspend fun userSignedIn() : Boolean{
        if(googleClient == null) return false

        val task: Task<GoogleSignInAccount> =
            googleClient.silentSignIn()

        val result = Tasks.await(task).id

//        val result =  task.addOnCompleteListener { task ->
//            if(task.isSuccessful){
//                task.getResult()
//            }
//        }


        return result != null
    }




    fun getGoogleClientSignInIntent() : Intent {
        return googleClient.signInIntent
    }






}