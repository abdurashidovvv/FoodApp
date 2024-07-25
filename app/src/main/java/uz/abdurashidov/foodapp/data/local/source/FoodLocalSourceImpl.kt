package uz.abdurashidov.foodapp.data.local.source

import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.foodapp.data.local.FoodDao
import uz.abdurashidov.foodapp.data.local.models.FoodEntity

class FoodLocalSourceImpl(private val foodDao: FoodDao) : FoodLocalSource {
    override suspend fun insertFood(foodEntity: FoodEntity) {
        foodDao.insertFood(foodEntity = foodEntity)
    }

    override suspend fun getAllFavoriteFoods(): Flow<List<FoodEntity>> {
        return foodDao.getAllFavoriteFoods()
    }

    override suspend fun deleteMealById(foodId: String) {
        foodDao.deleteFoodById(foodId = foodId)
    }

}