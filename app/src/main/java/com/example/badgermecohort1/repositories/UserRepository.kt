package com.example.badgermecohort1.repositories

import android.util.Log
import com.example.badgermecohort1.model.User
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface UserRepository {
    @GET("users")
    suspend fun getUsers() : Call<List<User>>

    @GET("users")
    // TODO: this is complaining about type annotation - not sure why
    suspend fun getUsersByEmail(@Query("email") String email) : Call<List<User>>

    companion object {

        var BASE_URL = "https://meek-hummingbird-b2e163.netlify.app/api/"

        fun create(loginRepository: LoginRepository): UserRepository {
            Log.d("User repository", "Creating user repository")
            Log.d("User repository", loginRepository.toString())

            val client = OkHttpClient.Builder().addInterceptor { chain ->
                Log.d("User repository", "Running interceptor")
                runBlocking {
                    // 'runBlocking' forces code with an async request to be executed synchronously
                    // since coroutines can't be used in the 'addInterceptor' block
                    val token = loginRepository.getUserToken()
                    val newRequest: Request = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer $token")
                        .build()
                    chain.proceed(newRequest)
                }
            }.build()

            val retrofit = Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(UserRepository::class.java)
        }
    }
}