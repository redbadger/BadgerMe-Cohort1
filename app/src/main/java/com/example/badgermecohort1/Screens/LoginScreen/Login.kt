package com.example.badgermecohort1.navigation

import android.app.Activity
import android.util.Log
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
import androidx.navigation.NavHostController
import com.example.badgermecohort1.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.tasks.Task

@Composable
fun login(navController: NavHostController, googleClient: GoogleSignInClient?) {
    val startForResult =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            Log.d("LogInPage", result.resultCode.toString())
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                Log.d("LogInPage", "Result.data")

                if (result.data != null) {
                    val task: Task<GoogleSignInAccount> =
                        GoogleSignIn.getSignedInAccountFromIntent(intent)
                    val result = task?.getResult()

                    if (result != null) {
                        Log.d("Log in page", result.idToken)
                    } else {
                        Log.d("Log in page", "No task result")
                    }
                    Log.d("LogInPage", "NavController")
                    navController.navigate("main_screen")
                    Log.d("Log in page", task.toString())
                }
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

