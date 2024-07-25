package uz.abdurashidov.foodapp.domain.repositories

import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.foodapp.data.remote.models.GetFoodByFoodId.Meal
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.domain.models.MealDetail
import uz.abdurashidov.foodapp.utils.DataState

interface FoodServiceRepository {
    suspend fun getMealByCategory(category: String): Flow<DataState<List<Food>>>
    suspend fun getFoodByFoodId(foodId: String): Flow<DataState<MealDetail>>
}