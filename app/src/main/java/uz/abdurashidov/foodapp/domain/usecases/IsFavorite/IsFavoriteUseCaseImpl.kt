package uz.abdurashidov.foodapp.domain.usecases.IsFavorite

import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.domain.repositories.FoodRepository
import javax.inject.Inject

class IsFavoriteUseCaseImpl @Inject constructor(
    private val foodRepository: FoodRepository
) : IsFavoriteUseCase {
    override suspend fun invoke(food: Food): Boolean {
        return foodRepository.isFavorite(food = food)
    }
}