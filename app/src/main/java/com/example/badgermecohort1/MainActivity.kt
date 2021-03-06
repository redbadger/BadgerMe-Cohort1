package com.example.badgermecohort1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.badgermecohort1.auth.getGoogleLoginAuth
import com.example.badgermecohort1.navigation.navigation
import com.example.badgermecohort1.ui.theme.BadgerMeCohort1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BadgerMeCohort1Theme {
                var googleClient = getGoogleLoginAuth(this)
                navigation(googleClient)
            }
        }
    }
}