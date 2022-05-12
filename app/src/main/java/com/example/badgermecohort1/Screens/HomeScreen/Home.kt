package com.example.badgermecohort1.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.badgermecohort1.R
import com.example.badgermecohort1.Screens.NavBar.BottomNavigationBar

@Composable
fun mainScreen(navController: NavController) {

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
    }

    Column() {
        Image(painter = painterResource(id = R.drawable.rb_title), contentDescription = "title")

    }
}