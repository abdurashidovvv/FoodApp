package uz.abdurashidov.foodapp.data.remote.source

import retrofit2.Response
import uz.abdurashidov.foodapp.data.remote.models.GetFoodByCategory.GetMealsByCategoryResponse
import uz.abdurashidov.foodapp.data.remote.models.GetFoodByFoodId.GetFoodByIdResponse

interface FoodServiceDataSource {

    suspend fun getMealsByCategory(category: String): Response<GetMealsByCategoryResponse>
    suspend fun getFoodByFoodId(foodId: String): Response<GetFoodByIdResponse>
}