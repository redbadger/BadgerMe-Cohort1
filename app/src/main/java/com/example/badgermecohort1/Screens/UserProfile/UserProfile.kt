package com.example.badgermecohort1.Screens.userProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.badgermecohort1.R
import com.example.badgermecohort1.Screens.LoginScreen.UserProfileViewModel

@Composable
fun userProfile(navController: NavHostController, userName: String) {
    val viewModel = hiltViewModel<UserProfileViewModel>()

    userProfileScreen(userName)
}

@Preview(showBackground = true)
@Composable
fun userProfileScreenPreview() {
    userProfileScreen(userName = "Peter Parker")
}


@Composable
fun userProfileScreen(userName: String) {
    var aboutMeText by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 49.dp)
    ) {
        Text(
            stringResource(
                R.string.user_profile_title),
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold)
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "profile avatar",
            modifier = Modifier.padding(Dp(50.0F))
        )
        TextField(
            value = userName,
            onValueChange = { },
            // Name is read only, based on the ACs
            readOnly = true,
            label = { Text(text = stringResource(R.string.name_label)) },
            placeholder = {Text(text = stringResource(R.string.name_placeholder)) },
            modifier = Modifier.padding(bottom = 16.dp),
            isError = false)
        TextField(
            value = aboutMeText,
            onValueChange = { aboutMeText = it},
            readOnly = true,
            label = { Text(text = stringResource(R.string.about_me_label)) },
            placeholder = {Text(text = stringResource(R.string.about_me_placeholder)) },
            isError = false)
        Row(modifier = Modifier.padding(bottom = 40.dp, start = 15.dp, end = 15.dp)) {
            Button(
                onClick = { },
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
                    .fillMaxWidth(),
            ) {
                Text(text = stringResource(R.string.continue_button))
            }
        }
    }
}
