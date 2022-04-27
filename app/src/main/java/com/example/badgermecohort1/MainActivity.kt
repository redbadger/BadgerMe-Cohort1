package com.example.badgermecohort1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.badgermecohort1.api.ApiInterface
import com.example.badgermecohort1.auth.getGoogleLoginAuth
import com.example.badgermecohort1.model.User
import com.example.badgermecohort1.navigation.navigation
import com.example.badgermecohort1.ui.theme.BadgerMeCohort1Theme
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    private var googleClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        googleClient = getGoogleLoginAuth(this)
        val users = ApiInterface.create().getUsers()
        users.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if(response?.body() != null) {
                    Log.d("MainActivity", response.body()!!.toString())
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                TODO("Not yet implemented")
                Log.d("MainActivity", "Failed")
            }
        })

        setContent {
            BadgerMeCohort1Theme {
                navigation(googleClient)
            }
        }
    }
}