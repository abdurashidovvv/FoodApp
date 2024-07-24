package uz.abdurashidov.foodapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.presentation.screens.components.AppBar
import uz.abdurashidov.foodapp.presentation.screens.components.DescriptionSection
import uz.abdurashidov.foodapp.presentation.screens.components.MainSection
import uz.abdurashidov.foodapp.presentation.screens.components.SearchBar

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Color.Black)
        ) {
            AppBar(menuOnClicked = {})
            DescriptionSection()
            SearchBar()
            MainSection(foods = listOf(
                Food(name = "Toast with Berries"),
                Food(name = "Toast with Berries"),
                Food(name = "Toast with Berries"),
                Food(name = "Toast with Berries"),
            ))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}