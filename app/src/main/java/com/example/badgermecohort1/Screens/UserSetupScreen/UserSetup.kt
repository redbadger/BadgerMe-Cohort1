package com.example.badgermecohort1.Screens.UserSetupScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.badgermecohort1.R
import com.example.badgermecohort1.ui.composable.interestsImage

@Composable
fun userSetup(navController: NavController){
    val userSetupViewModel = hiltViewModel<UserSetupViewModel>()

    Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top,
    modifier = Modifier.fillMaxSize()
    ) {
        Text(
            "What are you interested in?",
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f, true).fillMaxWidth()
        //TODO: Change this to use a for loop where we get the value for imageContainerTitle from the Interests API
        ) {
            Row() {
                interestsImage(imageResourceId = R.drawable.square, imageContainerTitle = "Food", viewModel = userSetupViewModel)
                interestsImage(imageResourceId = R.drawable.square_2, imageContainerTitle = "Chats", viewModel = userSetupViewModel )
            }
            Row() {
                interestsImage(imageResourceId = R.drawable.square_3, imageContainerTitle = "Walks", viewModel = userSetupViewModel )
                interestsImage(imageResourceId = R.drawable.square_4, imageContainerTitle = "Hugs", viewModel = userSetupViewModel)
            }
            Row() {
                interestsImage(imageResourceId = R.drawable.square_5, imageContainerTitle = "Badgers", viewModel = userSetupViewModel)
                interestsImage(imageResourceId = R.drawable.square_6, imageContainerTitle = "Drinks", viewModel = userSetupViewModel)

            }

        }
        Row(modifier = Modifier.padding(bottom = 40.dp, start = 15.dp, end = 15.dp)) {
            Button(
                enabled = true, //ToDo this needs to be enabled/disabled depending on if user has clicked on an interest image
                onClick = {
                    userSetupViewModel.addUserInterests(navController)
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
                    .fillMaxWidth()
            ) {
                Text("Continue")
            }
        }
    }
}