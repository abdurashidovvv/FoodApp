package uz.abdurashidov.foodapp.presentation.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import uz.abdurashidov.foodapp.presentation.screens.detail.components.DetailBar
import uz.abdurashidov.foodapp.presentation.screens.detail.components.TitleSection

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(it)
        ) {
            DetailBar()
            TitleSection()
        }
    }
}

@Preview
@Composable
private fun DetailScreenPreview() {
    DetailScreen()
}