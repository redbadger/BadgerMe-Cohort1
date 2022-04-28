package com.example.badgermecohort1.di

import android.content.Context
import com.example.badgermecohort1.repositories.LoginRepository
import com.example.badgermecohort1.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesLoginRepository(@ApplicationContext context: Context) : LoginRepository {
        return LoginRepository(context)
    }

    @Singleton
    @Provides
    fun providesUserRepository(loginRepository: LoginRepository): UserRepository {
        return UserRepository.create(loginRepository)
    }
}