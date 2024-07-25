package uz.abdurashidov.foodapp.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.presentation.navigation.NavigationItem
import uz.abdurashidov.foodapp.presentation.screens.home.components.AppBar
import uz.abdurashidov.foodapp.presentation.screens.home.components.DescriptionSection
import uz.abdurashidov.foodapp.presentation.screens.home.components.MainSection
import uz.abdurashidov.foodapp.presentation.screens.home.components.RecommendationItemCard
import uz.abdurashidov.foodapp.presentation.screens.home.components.RecommendationSection
import uz.abdurashidov.foodapp.presentation.screens.home.components.SearchBar
import uz.abdurashidov.foodapp.utils.DataState

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
    val foods by homeScreenViewModel.foods.collectAsState()


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
                        })
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