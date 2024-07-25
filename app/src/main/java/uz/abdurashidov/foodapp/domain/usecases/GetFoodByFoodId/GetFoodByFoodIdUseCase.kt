package uz.abdurashidov.foodapp.domain.usecases.GetFoodByFoodId

import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.foodapp.domain.models.MealDetail
import uz.abdurashidov.foodapp.utils.DataState

interface GetFoodByFoodIdUseCase {
    suspend operator fun invoke(foodId: String): Flow<DataState<MealDetail>>
}