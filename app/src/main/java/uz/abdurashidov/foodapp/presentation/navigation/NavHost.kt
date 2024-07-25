package uz.abdurashidov.foodapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.abdurashidov.foodapp.presentation.screens.detail.DetailScreen
import uz.abdurashidov.foodapp.presentation.screens.home.HomeScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavigationItem.HomeScreen.route
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavigationItem.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(NavigationItem.DetailScreen.route) {
            DetailScreen()
        }
    }
}