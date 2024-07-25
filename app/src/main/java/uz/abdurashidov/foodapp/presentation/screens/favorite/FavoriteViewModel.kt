package uz.abdurashidov.foodapp.presentation.screens.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.domain.usecases.AddFavoriteFood.AddFavoriteFoodUseCase
import uz.abdurashidov.foodapp.domain.usecases.DeleteFavoriteFood.DeleteFavoriteFoodUseCase
import uz.abdurashidov.foodapp.domain.usecases.GetFavoriteFood.GetFavoriteFoodUseCase
import uz.abdurashidov.foodapp.utils.DataState
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoriteFoodUseCase: GetFavoriteFoodUseCase,
    private val addFavoriteFoodUseCase: AddFavoriteFoodUseCase,
    private val deleteFavoriteFoodUseCase: DeleteFavoriteFoodUseCase
) : ViewModel() {
    private val _foods = MutableStateFlow<DataState<List<Food>>>(DataState.Loading())
    val food: StateFlow<DataState<List<Food>>> = _foods

    init {
        getAllFavoriteFoods()
    }

     fun getAllFavoriteFoods() {
        viewModelScope.launch {
            getFavoriteFoodUseCase.invoke().collect {
                _foods.value = it
            }
        }
    }

     fun addFavoriteFOod(food: Food) {
        viewModelScope.launch {
            addFavoriteFoodUseCase.invoke(food = food)
        }
    }

     fun deleteFavoriteFood(food: Food) {
        viewModelScope.launch {
            deleteFavoriteFoodUseCase.invoke(food = food)
        }
    }
}