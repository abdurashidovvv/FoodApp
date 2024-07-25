package uz.abdurashidov.foodapp.domain.usecases.AddFavoriteFood

import uz.abdurashidov.foodapp.domain.models.Food


interface AddFavoriteFoodUseCase {
    suspend operator fun invoke(food: Food)
}
