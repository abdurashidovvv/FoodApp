package uz.abdurashidov.foodapp.data.local.source

import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.foodapp.data.local.models.FoodEntity

interface FoodLocalSource {
    suspend fun insertFood(foodEntity: FoodEntity)
    suspend fun getAllFavoriteFoods(): Flow<List<FoodEntity>>
    suspend fun deleteMealById(foodId: String)
}