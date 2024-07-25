package uz.abdurashidov.foodapp.domain.usecases.DeleteFavoriteFood

import uz.abdurashidov.foodapp.domain.models.Food

interface DeleteFavoriteFoodUseCase {
    suspend operator fun invoke(food: Food)
}
