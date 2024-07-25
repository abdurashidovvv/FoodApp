package uz.abdurashidov.foodapp.domain.repositories

import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.foodapp.domain.models.Food

interface FoodRepository {
    suspend fun isFavorite(food: Food): Boolean
}