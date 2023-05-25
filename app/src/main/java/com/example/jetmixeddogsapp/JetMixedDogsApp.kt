package com.example.jetmixeddogsapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetmixeddogsapp.navigation.NavigationItems
import com.example.jetmixeddogsapp.navigation.Screen
import com.example.jetmixeddogsapp.ui.home.HomeScreen
import com.example.jetmixeddogsapp.ui.home.MixedDogsListItem
import com.example.jetmixeddogsapp.ui.theme.JetMixedDogsAppTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jetmixeddogsapp.model.MixedDogs
import com.example.jetmixeddogsapp.ui.about.AboutScreen

@Composable
fun JetMixedDogsApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailMixedDogs.route) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(it)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navigateToDetail = { data ->
                    navController.navigate(Screen.DetailMixedDogs.createRoute(data))
                }
                )
            }
            composable(Screen.About.route) {
                AboutScreen()
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        modifier = modifier
    ) {
        val navigationItems = listOf(
            NavigationItems(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home,
                contentDescription = stringResource(R.string.home_page)
            ),
            NavigationItems(
                title = stringResource(R.string.menu_about),
                icon = Icons.Default.AccountCircle,
                screen = Screen.About,
                contentDescription = stringResource(R.string.about_page)
            ),
        )
        BottomNavigation {
            navigationItems.map { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    label = { Text(item.title) },
                    selected = true,
                    onClick = {
                        navController.navigate(item.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JetMixedDogsAppPreview() {
    JetMixedDogsAppTheme {
        JetMixedDogsApp()
    }
}

//@Preview(showBackground = true)
//@Composable
//fun MixedDogsListItemPreview() {
//    JetMixedDogsAppTheme {
//        val data = MixedDogs("", "", "", "", "")
//        MixedDogsListItem(
//            id = "",
//            name = "Pomapoo",
//            photoUrl = "",
//            description = "Anjing ras campuran dengan induk pudel dan Pomeranian, sangat ramah, suka bermain, dan suka menjadi pusat perhatian.",
//            lifeSpan = "",
//            navigateToDetail = data
//        )
//    }
//}