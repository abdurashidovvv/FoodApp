package uz.abdurashidov.foodapp.data.remote.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import uz.abdurashidov.foodapp.data.remote.mappers.toListFood
import uz.abdurashidov.foodapp.data.remote.mappers.toMealDetail
import uz.abdurashidov.foodapp.data.remote.models.GetFoodByFoodId.Meal
import uz.abdurashidov.foodapp.data.remote.source.FoodServiceDataSource
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.domain.models.MealDetail
import uz.abdurashidov.foodapp.domain.repositories.FoodServiceRepository
import uz.abdurashidov.foodapp.utils.DataState
import javax.inject.Inject

class FoodServiceRepositoryImpl @Inject constructor(
    private val foodServiceDataSource: FoodServiceDataSource
) : FoodServiceRepository {
    override suspend fun getMealByCategory(category: String): Flow<DataState<List<Food>>> {
        return flow {
            emit(DataState.Loading())

            val response = foodServiceDataSource.getMealsByCategory(category = category)
            if (response.isSuccessful) {
                response.body()?.let { DataState.Success(it.toListFood()) }?.let { emit(it) }
            }
        }.catch { e ->
            emit(DataState.Error(e))
        }
    }

    override suspend fun getFoodByFoodId(foodId: String): Flow<DataState<List<MealDetail>>> {
        return flow {
            emit(DataState.Loading())

            val response = foodServiceDataSource.getFoodByFoodId(foodId = foodId)
            if (response.isSuccessful) {
                emit(DataState.Success(response.body()?.meals!!.map { it.toMealDetail() }))
            }
        }
    }
}