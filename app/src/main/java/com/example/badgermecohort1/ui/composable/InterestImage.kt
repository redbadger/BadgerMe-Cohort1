package com.example.badgermecohort1.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign

@Composable
fun interestsImage(
    imageResourceId : Int,
    contentDescription: String = "content description",
    imageContainerTitle: String
) {
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(imageResourceId),
            contentDescription = contentDescription
        )
        Text(text = imageContainerTitle, textAlign = TextAlign.Center)
        
    }
}

