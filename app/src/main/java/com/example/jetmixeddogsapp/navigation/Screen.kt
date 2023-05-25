package com.example.jetmixeddogsapp.navigation

import com.example.jetmixeddogsapp.model.MixedDogs

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object About: Screen("about")
    object DetailMixedDogs : Screen("home/{mixedDogs}") {
        fun createRoute(mixedDogs: MixedDogs) = "home/$mixedDogs"
    }
}