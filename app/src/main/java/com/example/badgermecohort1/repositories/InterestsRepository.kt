package com.example.badgermecohort1.repositories

import com.example.badgermecohort1.model.Interest
import retrofit2.http.GET
import retrofit2.http.PUT

interface InterestsRepository
{
    @GET("interests")
    suspend fun getInterests() : List<Interest>

    @PUT("interests")
    suspend fun setUserInterests()
}