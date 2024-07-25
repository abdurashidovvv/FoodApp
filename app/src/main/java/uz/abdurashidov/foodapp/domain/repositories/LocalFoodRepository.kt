package uz.abdurashidov.foodapp.domain.repositories

import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.utils.DataState

interface LocalFoodRepository {
    suspend fun insertFood(food: Food)
    suspend fun deleteFood(food: Food)
    suspend fun getAllFavoriteFoods(): Flow<DataState<List<Food>>>
}