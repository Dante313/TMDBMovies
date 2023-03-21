package com.example.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.ui.UpcomingScreen

const val upcomingNavigationRoute = "upcoming"

fun NavController.navigateToUpcoming(navOptions: NavOptions?) {
    this.navigate(upcomingNavigationRoute, navOptions)
}

fun NavGraphBuilder.upcomingScreen() {
    composable(route = upcomingNavigationRoute) {
        UpcomingScreen()
    }
}