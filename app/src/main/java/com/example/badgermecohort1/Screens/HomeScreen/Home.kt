package com.example.badgermecohort1.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.badgermecohort1.R
import com.example.badgermecohort1.Screens.HomeScreen.HomeViewModel

@Composable
fun mainScreen(navController: NavController) {
    val viewModel = hiltViewModel<HomeViewModel>()

    Column() {
        Image(painter = painterResource(id = R.drawable.rb_title), contentDescription = "title")

    }
}