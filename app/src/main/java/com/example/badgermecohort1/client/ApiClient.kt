package com.example.badgermecohort1.client

import android.util.Log
import com.example.badgermecohort1.R
import com.example.badgermecohort1.model.User
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiClient {
    @GET("users")
    suspend fun getUsers() : List<User>

    @GET("users")
    suspend fun getUsersByEmail(@Header("Authorization") token: String, @Query("email") email: String) : Response<List<User>>

    companion object {

        var BASE_URL = "https://meek-hummingbird-b2e163.netlify.app/api/"

        fun create(): ApiClient {
            val client = OkHttpClient.Builder().build()
            Log.d("ApiClient", "${R.string.login_description}")
            val retrofit = Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiClient::class.java)
        }
    }
}