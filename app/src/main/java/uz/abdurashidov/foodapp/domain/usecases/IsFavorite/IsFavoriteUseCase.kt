package uz.abdurashidov.foodapp.domain.usecases.IsFavorite

import uz.abdurashidov.foodapp.domain.models.Food

interface IsFavoriteUseCase {
    suspend operator fun invoke(food: Food):Boolean
}