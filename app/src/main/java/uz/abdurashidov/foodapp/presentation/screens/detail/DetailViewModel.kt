package uz.abdurashidov.foodapp.presentation.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.abdurashidov.foodapp.domain.models.MealDetail
import uz.abdurashidov.foodapp.domain.usecases.GetFoodByFoodId.GetFoodByFoodIdUseCase
import uz.abdurashidov.foodapp.utils.DataState
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getFoodByFoodIdUseCase: GetFoodByFoodIdUseCase
) : ViewModel() {

    private val _food = MutableStateFlow<DataState<MealDetail>>(DataState.Loading())
    val food: StateFlow<DataState<MealDetail>> = _food

    fun getFoodDetail(foodId: String) {
        viewModelScope.launch {
            getFoodByFoodIdUseCase.invoke(foodId = foodId).collect { food ->
                _food.value = food
            }
        }
    }
}