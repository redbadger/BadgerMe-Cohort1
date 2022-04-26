package com.example.badgermecohort1.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.badgermecohort1.R

@Composable
fun MainScreen(navController: NavController) {
    Column() {
        Image(painter = painterResource(id = R.drawable.rb_title), contentDescription = "title")

    }
}