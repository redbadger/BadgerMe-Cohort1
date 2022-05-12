package com.example.badgermecohort1.Screens.NavBar

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.badgermecohort1.R
import com.example.badgermecohort1.navigation.BottomNavBar

@Composable
fun BottomNavigationBar(navController: NavController) {

    val bottomNavItems = listOf(
        BottomNavBar.Home,
        BottomNavBar.Activity,
        BottomNavBar.Profile,
        BottomNavBar.Badgers
    )

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.black),
        contentColor = Color.White
    ) {
        val currentRoute = navController.currentBackStackEntry?.destination?.route


        bottomNavItems.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title)},
                label = { Text(text = item.title)},
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    if(currentRoute != item.screen_route) {
                        navController.navigate(item.screen_route)
                    }

                }
            )
        }
    }


}