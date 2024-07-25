package uz.abdurashidov.foodapp.domain.usecases.GetFavoriteFood

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.domain.repositories.LocalFoodRepository
import uz.abdurashidov.foodapp.utils.DataState
import javax.inject.Inject

class GetFavoriteFoodUseCaseImpl @Inject constructor(
    private val localFoodRepository: LocalFoodRepository
) : GetFavoriteFoodUseCase {
    override fun invoke(): Flow<DataState<List<Food>>> {
        return localFoodRepository.getAllFavoriteFoods()
    }

}