package com.example.badgermecohort1.Screens.HomeScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : ViewModel() {
    init {
        Log.d("Home view model", "Being created!")
    }
}