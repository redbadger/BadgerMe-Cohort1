package com.example.badgermecohort1.api

import com.example.badgermecohort1.model.User
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

        fun create() : ApiInterface {

            val token = "eyJhbGciOiJSUzI1NiIsImtpZCI6Ijg2MTY0OWU0NTAzMTUzODNmNmI5ZDUxMGI3Y2Q0ZTkyMjZjM2NkODgiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiIzNzM5NzEzODEyMzQtN3ZwczViZTcyZGNjdmcxYmV2bzlmdTg5aHY3c241N2kuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiIzNzM5NzEzODEyMzQtaWRhdGlvZWlvZDRiYXRqbjhhcW1sdTFxdjhiYWs4ZHAuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMTAxOTk3NjgzMzM2NTc4OTcyMjMiLCJoZCI6InJlZC1iYWRnZXIuY29tIiwiZW1haWwiOiJkZWVuLmJhc2hpckByZWQtYmFkZ2VyLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJuYW1lIjoiRGVlbiBCYXNoaXIiLCJwaWN0dXJlIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbnQuY29tL2EvQUFUWEFKd2xZUHNxT1FhUFRWUjhpekZqb1FULTRickZPWUtPRkl6NGtBLVA9czk2LWMiLCJnaXZlbl9uYW1lIjoiRGVlbiIsImZhbWlseV9uYW1lIjoiQmFzaGlyIiwibG9jYWxlIjoiZW4tR0IiLCJpYXQiOjE2NTEwNTU5NTAsImV4cCI6MTY1MTA1OTU1MH0.dIO3P5Sp3K8hY1JOoRUgDu4Tm0mAqQRTnaTV7AZH1RE78CL6IGTZkDoGSobzighOvLqPK5r8pkVPdGsrb-_WbAbWRWwP723u-LFtVFAngrSo7ZtwbpVSMCbGttcJzv0M7Q1iUKSZgFqN4qzSORiusp24iQ6KS0EL0Ev6D-tQ6OfiMkjo4iaPqYITRpXNoTyWjX5o8TOAWtWXxgrkJBY5op3kObLKpAss06xDASWlBj_AOA4spT9t1p7ucHZAq2Ud_ncI5Ft8EVk8hJPTDNFU2JWC5M-7DxIdNOdJBpH3m5eAEtwZgnizaiwBtmMqOAn4v7TrHGriR9pJRLLrID5wzQ"

            val client = OkHttpClient.Builder().addInterceptor { chain ->
                val newRequest: Request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .build()
                chain.proceed(newRequest)
            }.build()


            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }




}