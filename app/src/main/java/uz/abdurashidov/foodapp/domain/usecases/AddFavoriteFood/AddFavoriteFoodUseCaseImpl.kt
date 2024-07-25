package uz.abdurashidov.foodapp.domain.usecases.AddFavoriteFood

import uz.abdurashidov.foodapp.data.local.mappers.toFood
import uz.abdurashidov.foodapp.data.local.models.FoodEntity
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.domain.repositories.LocalFoodRepository
import javax.inject.Inject

class AddFavoriteFoodUseCaseImpl @Inject constructor(
    private val localFoodRepository: LocalFoodRepository
) : AddFavoriteFoodUseCase {
    override suspend fun invoke(food: Food) {
        localFoodRepository.insertFood(food = food)
    }
}