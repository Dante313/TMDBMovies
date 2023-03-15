package com.example.upcoming.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.upcoming.UpcomingScreen

const val upcomingNavigationRoute = "upcoming"

fun NavController.navigateToUpcoming(navOptions: NavOptions?) {
    this.navigate(upcomingNavigationRoute, navOptions)
}

fun NavGraphBuilder.upcomingScreen() {
    composable(route = upcomingNavigationRoute) {
        UpcomingScreen()
    }
}