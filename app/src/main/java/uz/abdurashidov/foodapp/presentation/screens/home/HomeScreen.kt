package uz.abdurashidov.foodapp.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.presentation.navigation.NavigationItem
import uz.abdurashidov.foodapp.presentation.screens.favorite.FavoriteViewModel
import uz.abdurashidov.foodapp.presentation.screens.home.components.AppBar
import uz.abdurashidov.foodapp.presentation.screens.home.components.DescriptionSection
import uz.abdurashidov.foodapp.presentation.screens.home.components.MainSection
import uz.abdurashidov.foodapp.presentation.screens.home.components.RecommendationItemCard
import uz.abdurashidov.foodapp.presentation.screens.home.components.RecommendationSection
import uz.abdurashidov.foodapp.presentation.screens.home.components.SearchBar
import uz.abdurashidov.foodapp.presentation.theme.LoraRegular
import uz.abdurashidov.foodapp.presentation.theme.LoraSemiBold
import uz.abdurashidov.foodapp.presentation.theme.MainTextColor
import uz.abdurashidov.foodapp.utils.DataState

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
    val foods by homeScreenViewModel.foods.collectAsState()
    val isFav by homeScreenViewModel.isFav.collectAsState()

    //ulgurilmadi, shuning uchun yozib ketildi bu viewmodel
    val favoriteViewModel: FavoriteViewModel = hiltViewModel()

    val drawerState = rememberDrawerState(DrawerValue.Closed)


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.Black,
            ) {
                Text(
                    text = "Hello, Denny",
                    fontSize = 24.sp,
                    fontFamily = LoraSemiBold,
                    color = MainTextColor,
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)
                )
                Divider()
                NavigationDrawerItem(
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color.Black,
                        unselectedContainerColor = Color.Black,
                    ),
                    label = {
                        Text(
                            text = "Favorite",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontFamily = LoraRegular
                        )
                    },
                    selected = false,
                    onClick = {
                        navController.navigate(NavigationItem.FavoriteScreen.route)
                    }
                )
            }
        },
    ) {
        Scaffold {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(Color.Black)
            ) {
                item {
                    AppBar(menuOnClicked = {})
                }
                item {
                    DescriptionSection()
                }
                item {
                    SearchBar()
                }

                item {
                    when (foods) {
                        is DataState.Error -> {}
                        is DataState.Loading -> {
                            Box(modifier = Modifier.fillMaxSize()) {
                                CircularProgressIndicator()
                            }
                        }

                        is DataState.Success -> {
                            MainSection(
                                foods = (foods as DataState.Success<List<Food>>).data,
                                foodCardOnClicked = { foodId ->
                                    navController.navigate(NavigationItem.DetailScreen.route + "/$foodId")
                                }
                            )
                        }
                    }
                }

                item {
                    RecommendationSection()
                }

                when (foods) {
                    is DataState.Error -> {}
                    is DataState.Loading -> {
                        item {
                            Box(modifier = Modifier.fillMaxSize()) {
                                CircularProgressIndicator()
                            }
                        }
                    }

                    is DataState.Success -> {
                        items((foods as DataState.Success<List<Food>>).data) { food ->
                            RecommendationItemCard(food = food, foodCardOnClicked = {
                                navController.navigate(NavigationItem.DetailScreen.route + "/${food.foodId}")
                            },
                                isFav = isFav,
                                homeScreenViewModel = homeScreenViewModel,
                                likedOnClicked = { food ->
                                    if (isFav) {
                                        favoriteViewModel.deleteFavoriteFood(food = food)
                                    }else{
                                        favoriteViewModel.addFavoriteFOod(food = food)
                                    }
                                })
                        }
                    }
                }
            }
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//private fun HomeScreenPreview() {
//    HomeScreen()
//}