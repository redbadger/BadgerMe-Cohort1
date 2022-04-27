package com.example.badgermecohort1.api

import android.util.Log
import com.example.badgermecohort1.model.User
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.tasks.Task
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiInterface {
    @GET("users")
    fun getUsers() : Call<List<User>>

    companion object {

        var BASE_URL = "https://meek-hummingbird-b2e163.netlify.app/api/"

        fun create(token: String?): ApiInterface {
//            val token = "eyJhbGciOiJSUzI1NiIsImtpZCI6Ijg2MTY0OWU0NTAzMTUzODNmNmI5ZDUxMGI3Y2Q0ZTkyMjZjM2NkODgiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiIzNzM5NzEzODEyMzQtZThrcHZ1dnI3cDAxZWg5bWswdmtwbTIzazEyazFrcnIuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiIzNzM5NzEzODEyMzQtaWRhdGlvZWlvZDRiYXRqbjhhcW1sdTFxdjhiYWs4ZHAuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMDAzNjg4ODg4NjY0NjY2NjExNDYiLCJoZCI6InJlZC1iYWRnZXIuY29tIiwiZW1haWwiOiJ0aW0ubGVlQHJlZC1iYWRnZXIuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsIm5hbWUiOiJUaW0gTGVlIiwicGljdHVyZSI6Imh0dHBzOi8vbGgzLmdvb2dsZXVzZXJjb250ZW50LmNvbS9hLS9BT2gxNEdocUJXUDdnQlktMk5oUWkxRWNmcW9JNFYxZnRVdm1HV2R2MXBMMT1zOTYtYyIsImdpdmVuX25hbWUiOiJUaW0iLCJmYW1pbHlfbmFtZSI6IkxlZSIsImxvY2FsZSI6ImVuLUdCIiwiaWF0IjoxNjUxMDU2Njc2LCJleHAiOjE2NTEwNjAyNzZ9.dc-I-UtAyhHFdszJW9wHwkgNzmcsxRDxcD0tS6yyvJdXRV-pjOUhpnm7_DpEh8VDbQ9Hxnz8Rxxsz_tbJikUlSNfUytKtcmhIeDHGiSrQAbkGD8bPOlLwwEZ_vraAccli6VGx7Q-0XxjZYhEKbqOLj2jjxzfFA_UaJVz_DqWaYE6vigkYubXOLo-iomjdxlUxbX1WwaG_EYxT8r8vanOueIAmmR1yoXxCljJWa3j0cNgXM_AIZaOgyKyavxOqGWGKB2s4FGEKMZsG4jaQIygCm2hc-X19pNMgPCI0XqHaMRbfC3pFhW2iHEvdxkY09fr8fNKPYhX3Jah4VhVWyHCvQ"

            val client = OkHttpClient.Builder().addInterceptor { chain ->
                val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
                chain.proceed(newRequest)
            }.build()


            val retrofit = Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }




}