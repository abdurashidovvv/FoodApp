package uz.abdurashidov.foodapp.data.local.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import uz.abdurashidov.foodapp.data.local.mappers.toFood
import uz.abdurashidov.foodapp.data.local.models.FoodEntity
import uz.abdurashidov.foodapp.data.local.source.FoodLocalSource
import uz.abdurashidov.foodapp.domain.mappers.toFoodEntity
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.domain.repositories.LocalFoodRepository
import uz.abdurashidov.foodapp.utils.DataState
import javax.inject.Inject

class LocalFoodRepositoryImpl @Inject constructor(
    private val foodLocalSource: FoodLocalSource
) : LocalFoodRepository {
    override suspend fun insertFood(food: Food) {
        withContext(Dispatchers.IO){
            foodLocalSource.insertFood(foodEntity = food.toFoodEntity())
        }
    }

    override  fun deleteFood(food: Food) {
        foodLocalSource.deleteFoodById(foodId = food.foodId)
    }

    override fun getAllFavoriteFoods(): Flow<DataState<List<Food>>> {
        return flow {
            emit(DataState.Loading())

            try {
                foodLocalSource.getAllFavoriteFoods().collect {
                    emit(DataState.Success(it.map { foodEntity -> foodEntity.toFood() }))
                }
            } catch (e: Exception) {
                emit(DataState.Error(Exception(e.message)))
            }
        }
    }
}