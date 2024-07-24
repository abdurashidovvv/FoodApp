package uz.abdurashidov.foodapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.presentation.screens.components.AppBar
import uz.abdurashidov.foodapp.presentation.screens.components.DescriptionSection
import uz.abdurashidov.foodapp.presentation.screens.components.MainSection
import uz.abdurashidov.foodapp.presentation.screens.components.RecommendationItemCard
import uz.abdurashidov.foodapp.presentation.screens.components.SearchBar

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val foods by remember {
        mutableStateOf(
            listOf(
                Food(name = "Toast with Berries"),
                Food(name = "Toast with Berries"),
                Food(name = "Toast with Berries"),
                Food(name = "Toast with Berries"),
            )
        )
    }

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
                MainSection(
                    foods = listOf(
                        Food(name = "Toast with Berries"),
                        Food(name = "Toast with Berries"),
                        Food(name = "Toast with Berries"),
                        Food(name = "Toast with Berries"),
                    )
                )
            }

            items(foods) { food ->
                RecommendationItemCard(food = food)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}