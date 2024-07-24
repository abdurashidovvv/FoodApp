package uz.abdurashidov.foodapp.domain.usecases.GetFoodByCategory

import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.foodapp.domain.models.Food
import uz.abdurashidov.foodapp.domain.repositories.FoodServiceRepository
import uz.abdurashidov.foodapp.utils.DataState
import javax.inject.Inject

class GetFoodByCategoryUseCaseImpl @Inject constructor(
    private val foodServiceRepository: FoodServiceRepository
) : GetFoodByCategoryUseCase {
    override suspend fun invoke(category: String): Flow<DataState<List<Food>>> {
        return foodServiceRepository.getMealByCategory(category = category)
    }
}