package uz.abdurashidov.foodapp.domain.usecases.GetFavoriteFood

import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.utils.DataState

interface GetFavoriteFoodUseCase {
    operator fun invoke(): Flow<DataState<List<Food>>>
}