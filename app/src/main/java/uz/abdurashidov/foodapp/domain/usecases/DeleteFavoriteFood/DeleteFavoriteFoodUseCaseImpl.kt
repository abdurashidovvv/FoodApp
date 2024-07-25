package uz.abdurashidov.foodapp.domain.usecases.DeleteFavoriteFood

import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.domain.repositories.LocalFoodRepository
import javax.inject.Inject

class DeleteFavoriteFoodUseCaseImpl @Inject constructor(
    private val localFoodRepository: LocalFoodRepository
) : DeleteFavoriteFoodUseCase {
    override suspend fun invoke(food: Food) {
        localFoodRepository.deleteFood(food = food)
    }
}