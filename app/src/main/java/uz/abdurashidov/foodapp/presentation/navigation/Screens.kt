package uz.abdurashidov.foodapp.presentation.navigation

enum class Screens {
    HOME_SCREEN,
    DETAIL_SCREEN,
    FAVORITE_SCREEN
}

sealed class NavigationItem(val route:String){
    object HomeScreen:NavigationItem(Screens.HOME_SCREEN.name)
    object DetailScreen:NavigationItem(Screens.DETAIL_SCREEN.name)
    object FavoriteScreen:NavigationItem(Screens.FAVORITE_SCREEN.name)
}