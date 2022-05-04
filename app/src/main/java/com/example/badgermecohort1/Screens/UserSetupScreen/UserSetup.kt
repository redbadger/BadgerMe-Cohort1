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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.badgermecohort1.R
import com.example.badgermecohort1.ui.composable.interestsImage

@Preview(showBackground = true)
@Composable
fun userSetup(navController: NavController){
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
        modifier = Modifier.weight(1f, true)
    ) {
        Row() {
            interestsImage(imageResourceId = R.drawable.square, imageContainerTitle = "Food" )
            interestsImage(imageResourceId = R.drawable.square_2, imageContainerTitle = "Drinks" )
        }
        Row() {
            interestsImage(imageResourceId = R.drawable.square_3, imageContainerTitle = "Coffee" )
            interestsImage(imageResourceId = R.drawable.square_4, imageContainerTitle = "Chats")
        }
        Row() {
            interestsImage(imageResourceId = R.drawable.square_5, imageContainerTitle = "Walks")
            interestsImage(imageResourceId = R.drawable.square_6, imageContainerTitle = "Hugs")

        }

    }
    Row(modifier = Modifier.padding(bottom = 40.dp, start = 15.dp, end = 15.dp)) {
        Button(
            onClick = { navController.navigate("user_profile")},
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
                .fillMaxWidth()
        ) {
            Text("Continue")
        }
    }
}
}