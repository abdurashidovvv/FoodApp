package uz.abdurashidov.foodapp.data.local.source

import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.foodapp.data.local.FoodDao
import uz.abdurashidov.foodapp.data.local.models.FoodEntity
import javax.inject.Inject

class FoodLocalSourceImpl @Inject constructor(private val foodDao: FoodDao) : FoodLocalSource {
    override fun insertFood(foodEntity: FoodEntity) {
        foodDao.insertFood(foodEntity = foodEntity)
    }

    override fun getAllFavoriteFoods(): Flow<List<FoodEntity>> {
        return foodDao.getAllFavoriteFoods()
    }

    override fun deleteFoodById(foodId: String): Int {
        return foodDao.deleteFoodById(foodId = foodId)
    }

}