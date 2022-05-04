package com.example.badgermecohort1.repositories

import android.util.Log
import com.example.badgermecohort1.client.ApiClient
import com.example.badgermecohort1.model.User
import javax.inject.Inject


class UserRepository @Inject constructor(private val apiClient: ApiClient, private val loginRepository: LoginRepository) {

    suspend fun getUserByEmail(email: String) : UserResponse {
        val token = loginRepository.getUserToken() ?: return UserResponse(error = UserResponseError.NotLoggedIn)

        val response = apiClient.getUsersByEmail("Bearer $token", email)

        if (response.isSuccessful) {
            val users = response.body()
            if (users?.isNotEmpty() == true) {
                return UserResponse(user = users.first())
            }

            return UserResponse(error = UserResponseError.UserDoesNotExist)
        }

        val errorCode = response.code()
        if (errorCode == 401) {
            return UserResponse(error = UserResponseError.InvalidToken)
        }

        Log.d("UserRepository", "Error code: $errorCode")
        return UserResponse(error = UserResponseError.OtherError)
    }
}

enum class UserResponseError {
    NotLoggedIn,
    InvalidToken,
    UserDoesNotExist,
    OtherError
}

data class UserResponse(val user: User? = null, val error: UserResponseError? = null)