package uz.abdurashidov.foodapp.presentation.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import uz.abdurashidov.foodapp.presentation.screens.detail.components.DescriptionSection
import uz.abdurashidov.foodapp.presentation.screens.detail.components.DetailBar
import uz.abdurashidov.foodapp.presentation.screens.detail.components.IngredientSection
import uz.abdurashidov.foodapp.presentation.screens.detail.components.InstructionSection
import uz.abdurashidov.foodapp.presentation.screens.detail.components.TitleSection

@Composable
fun DetailScreen(modifier: Modifier = Modifier, foodId:String) {
    val scrollState = rememberScrollState()
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(state = scrollState)
                .background(Color.Black)

        ) {
            DetailBar()
            TitleSection()
            DescriptionSection()
            IngredientSection()
            InstructionSection()
        }
    }
}

//@Preview
//@Composable
//private fun DetailScreenPreview() {
//    DetailScreen()
//}