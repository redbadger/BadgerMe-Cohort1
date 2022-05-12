package com.example.badgermecohort1.navigation

import com.example.badgermecohort1.R

sealed class BottomNavBar(var title: String, var icon: Int, var screen_route: String) {
    object Home : BottomNavBar("Home", R.drawable.home_button, "home")
    object Badgers : BottomNavBar("Badgers", R.drawable.ic_launcher_background, "badgers")
    object Profile : BottomNavBar("Profile", R.drawable.ic_launcher_background, "profile")
    object Activity : BottomNavBar("Activity", R.drawable.rectangle_42__stroke_, "activity")
}
