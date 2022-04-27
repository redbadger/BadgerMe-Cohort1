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
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
//    private var googleClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var googleClient = getGoogleLoginAuth(this)

        // Do silent sign in
        // If successful
        // --> initialise api interface with token
        // --> query whether user exists already
        //      --> if user exists take to main screen
        //      --> if not take to profile create screen
        // If not - take to login screen

        val task: Task<GoogleSignInAccount> =
            googleClient.silentSignIn()
        val result = task?.getResult()

        if (result != null) {
            val users = ApiInterface.create(result.idToken).getUsers()
            users.enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    if(response?.body() != null) {
                        setContent {
                            BadgerMeCohort1Theme {
                                navigation(googleClient)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    TODO("Not yet implemented")
                    Log.d("MainActivity", "Failed")
                }
            })
        } else {
            setContent {
                BadgerMeCohort1Theme {
                    navigation(googleClient)
                }
            }
        }

        setContent {
            BadgerMeCohort1Theme {
                navigation(googleClient)
            }
        }
    }
}