package com.example.badgermecohort1.auth

import android.content.Context
import android.provider.Settings.Global.getString
import com.example.badgermecohort1.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions


fun getGoogleLoginAuth(context: Context): GoogleSignInClient {
    val signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//         Request id token if you intend to verify google user from your backend server
//        .requestIdToken(context.getString(R.string.backend_client_id))
        //.requestEmail()
        .requestIdToken("373971381234-idatioeiod4batjn8aqmlu1qv8bak8dp.apps.googleusercontent.com")
        .build()

    return GoogleSignIn.getClient(context, signInOptions)
}