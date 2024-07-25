package uz.abdurashidov.foodapp.domain.usecases.GetFoodByFoodId

import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.foodapp.domain.models.MealDetail
import uz.abdurashidov.foodapp.domain.repositories.FoodServiceRepository
import uz.abdurashidov.foodapp.utils.DataState
import javax.inject.Inject

class GetFoodByFoodIdUseCaseImpl @Inject constructor(
    private val foodServiceRepository: FoodServiceRepository
):GetFoodByFoodIdUseCase {
    override suspend fun invoke(foodId: String): Flow<DataState<MealDetail>> {
        return foodServiceRepository.getFoodByFoodId(foodId = foodId)
    }
}