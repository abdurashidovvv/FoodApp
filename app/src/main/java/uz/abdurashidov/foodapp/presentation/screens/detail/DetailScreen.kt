package uz.abdurashidov.foodapp.presentation.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import uz.abdurashidov.foodapp.domain.models.MealDetail
import uz.abdurashidov.foodapp.presentation.screens.detail.components.DescriptionSection
import uz.abdurashidov.foodapp.presentation.screens.detail.components.DetailBar
import uz.abdurashidov.foodapp.presentation.screens.detail.components.IngredientSection
import uz.abdurashidov.foodapp.presentation.screens.detail.components.InstructionSection
import uz.abdurashidov.foodapp.presentation.screens.detail.components.TitleSection
import uz.abdurashidov.foodapp.utils.DataState
import javax.annotation.meta.When

@Composable
fun DetailScreen(modifier: Modifier = Modifier, navController: NavController, foodId: String) {

    val detailViewModel: DetailViewModel = hiltViewModel()

    LaunchedEffect(key1 = Unit) {
        detailViewModel.getFoodDetail(foodId = foodId)
    }

    val food by detailViewModel.food.collectAsState()
    val scrollState = rememberScrollState()

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(state = scrollState)
                .background(Color.Black)

        ) {
            DetailBar(backOnClicked = {
                navController.navigateUp()
            })
            when (food) {
                is DataState.Error -> {}
                is DataState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize()) {
                        CircularProgressIndicator()
                    }
                }

                is DataState.Success -> {
                    TitleSection(foodName = (food as DataState.Success<MealDetail>).data.foodName)
                    DescriptionSection(
                        foodArea = (food as DataState.Success<MealDetail>).data.foodArea,
                        foodImageURL = (food as DataState.Success<MealDetail>).data.foodImageURL
                    )
                    IngredientSection(ingredients = (food as DataState.Success<MealDetail>).data.ingredientList)
                    InstructionSection(instruction = (food as DataState.Success<MealDetail>).data.instruction)
                }
            }
        }
    }
}

//@Preview
//@Composable
//private fun DetailScreenPreview() {
//    DetailScreen()
//}