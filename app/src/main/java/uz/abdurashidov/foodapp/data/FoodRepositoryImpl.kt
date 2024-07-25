package uz.abdurashidov.foodapp.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uz.abdurashidov.foodapp.data.local.source.FoodLocalSource
import uz.abdurashidov.foodapp.data.remote.source.FoodServiceDataSource
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.domain.repositories.FoodRepository
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val localSource: FoodLocalSource
) : FoodRepository {
    override suspend fun isFavorite(food: Food): Boolean {
        var result = false
        localSource.getAllFavoriteFoods().collect { foodFromApi ->
            if (foodFromApi.isNotEmpty()){
                if (food.foodId == foodFromApi[0].foodId) result = true
            }
        }
        return result
    }

}