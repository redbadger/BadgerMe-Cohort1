package com.example.badgermecohort1.navigation

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.badgermecohort1.R
import com.example.badgermecohort1.Screens.LoginScreen.LoginViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInClient

@Composable
fun login(navController: NavHostController, googleClient: GoogleSignInClient?) {
    val loginViewModel = hiltViewModel<LoginViewModel>()
    var showError = remember {mutableStateOf<Boolean>(false)}
    val composableScope = rememberCoroutineScope()

    val startForResult =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val userAccount = loginViewModel.getUserAccount(result)
            if (userAccount != null) {
                loginViewModel.navigateUser(userAccount.email, navController, composableScope)
                showError.value = false
            } else {
                showError.value = true
            }
        }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.rb_title),
            contentDescription = "rb title",
            modifier = Modifier.padding(Dp(50.0F))
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f, true)
        ) {
            Row() {
                Image(
                    painter = painterResource(R.drawable.square),
                    contentDescription = "square1", //TODO: Rename images based on category & create repeated image component
                    modifier = Modifier
                        .padding(5.dp)
                        .size(96.dp)
                )
                Image(
                    painter = painterResource(R.drawable.square_2),
                    contentDescription = "square2",
                    modifier = Modifier
                        .padding(5.dp)
                        .size(96.dp)
                )

            }
            Row() {
                Image(
                    painter = painterResource(R.drawable.square_3),
                    contentDescription = "square3",
                    modifier = Modifier
                        .padding(5.dp)
                        .size(96.dp)
                )
                Image(
                    painter = painterResource(R.drawable.square_4),
                    contentDescription = "square4",
                    modifier = Modifier
                        .padding(5.dp)
                        .size(96.dp)

                )

            }
            Row() {
                Image(
                    painter = painterResource(R.drawable.square_5),
                    contentDescription = "square5",
                    modifier = Modifier
                        .padding(5.dp)
                        .size(96.dp)
                )
                Image(
                    painter = painterResource(R.drawable.square_6),
                    contentDescription = "square6",
                    modifier = Modifier
                        .padding(5.dp)
                        .size(96.dp)
                )

            }
            Row(modifier = Modifier.padding(horizontal = 40.dp)) {
                Text(
                    text = stringResource(R.string.login_description),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.subtitle1,
                    color = colorResource(R.color.off_black),
                    modifier = Modifier.padding(vertical = 16.dp)
                )

            }
        }
        if (showError.value){
            Text(
                "Error signing in",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                style = MaterialTheme.typography.subtitle1,
                color = colorResource(R.color.red),
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }


        Row(modifier = Modifier.padding(bottom = 40.dp, start = 15.dp, end = 15.dp)) {
            Button(
                onClick = { startForResult.launch(googleClient?.signInIntent) },
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
                    .fillMaxWidth()
            ) {
                Text(stringResource(R.string.login_sign_in_with_google))
            }
        }
    }
}


