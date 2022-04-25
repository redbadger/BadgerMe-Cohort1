package com.example.badgermecohort1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.badgermecohort1.auth.getGoogleLoginAuth
import com.example.badgermecohort1.ui.theme.BadgerMeCohort1Theme
import com.example.badgermecohort1.navigation.navigation
import com.google.android.gms.auth.api.signin.GoogleSignInClient

class MainActivity : ComponentActivity() {
    private var googleClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        googleClient = getGoogleLoginAuth(this)

        setContent {
            BadgerMeCohort1Theme {
                navigation(googleClient)
            }
        }
    }
}