package uz.abdurashidov.foodapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.domain.usecases.GetFoodByCategory.GetFoodByCategoryUseCase
import uz.abdurashidov.foodapp.utils.DataState
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getFoodByCategoryUseCase: GetFoodByCategoryUseCase
) : ViewModel() {
    private val _foods = MutableStateFlow<DataState<List<Food>>>(DataState.Loading())
    val foods: StateFlow<DataState<List<Food>>> = _foods

    init {
        getFoodByCategory(category = "Seafood")
    }
    private fun getFoodByCategory(category: String) {
        viewModelScope.launch {
            getFoodByCategoryUseCase.invoke(category = category).collectLatest { foodState ->
                _foods.value = foodState
            }
        }
    }
}