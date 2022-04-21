package com.example.badgermecohort1.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import com.example.badgermecohort1.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreenAnimate(navController: NavController) {

    //ToDo: Need to change this so splash screen only lasts as long as it takes to load main screen
    LaunchedEffect(key1 = true){
        delay(1000)
        navController.navigate("main_screen"){
            popUpTo("splash_screen"){
                inclusive=true
            }
        }
    }

    BoxWithConstraints(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.rb_title),
            contentDescription = "rb title",
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Image(
            painter = painterResource(R.drawable.rb_logo),
            contentDescription = "Splash Image",
            Modifier.padding(Dp(10.0F))
        )
        Text(text = "Loading")
    }




}