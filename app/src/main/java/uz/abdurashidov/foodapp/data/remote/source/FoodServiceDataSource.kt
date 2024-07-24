package uz.abdurashidov.foodapp.data.remote.source

import retrofit2.Response
import uz.abdurashidov.foodapp.data.remote.models.GetFoodByCategory.GetMealsByCategoryResponse

interface FoodServiceDataSource {

    suspend fun getMealsByCategory(category:String): Response<GetMealsByCategoryResponse>
}