package uz.abdurashidov.foodapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import uz.abdurashidov.foodapp.presentation.screens.detail.DetailScreen
import uz.abdurashidov.foodapp.presentation.screens.favorite.FavoriteScreen
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

        composable(
            NavigationItem.DetailScreen.route + "/{foodId}", arguments = listOf(
                navArgument("foodId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val foodId = backStackEntry.arguments?.getString("foodId") ?: "52959"
            DetailScreen(navController = navController, foodId = foodId)
        }

        composable(NavigationItem.FavoriteScreen.route) {
            FavoriteScreen(navController = navController)
        }
    }
}