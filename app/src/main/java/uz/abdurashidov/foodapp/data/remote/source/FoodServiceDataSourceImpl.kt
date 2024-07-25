package uz.abdurashidov.foodapp.data.remote.source

import retrofit2.Response
import uz.abdurashidov.foodapp.data.remote.FoodService
import uz.abdurashidov.foodapp.data.remote.models.GetFoodByCategory.GetMealsByCategoryResponse
import uz.abdurashidov.foodapp.data.remote.models.GetFoodByFoodId.GetFoodByIdResponse

class FoodServiceDataSourceImpl(
    private val foodService: FoodService
) : FoodServiceDataSource {
    override suspend fun getMealsByCategory(category: String): Response<GetMealsByCategoryResponse> {
        return foodService.getMealsByCategory(category = category)
    }

    override suspend fun getFoodByFoodId(foodId: String): Response<GetFoodByIdResponse> {
        return foodService.getFoodById(mealId = foodId)
    }
}