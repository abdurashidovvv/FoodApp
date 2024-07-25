package uz.abdurashidov.foodapp.data.local.source

import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.foodapp.data.local.models.FoodEntity

interface FoodLocalSource {
    fun insertFood(foodEntity: FoodEntity)
    fun getAllFavoriteFoods(): Flow<List<FoodEntity>>
    fun deleteFoodById(foodId: String): Int
}