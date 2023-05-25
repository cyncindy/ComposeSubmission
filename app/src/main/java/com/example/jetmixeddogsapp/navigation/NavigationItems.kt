package com.example.jetmixeddogsapp.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItems(
    val title: String,
    val icon: ImageVector,
    val screen: Screen,
    val contentDescription: String,
)