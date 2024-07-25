package uz.abdurashidov.foodapp.domain.mappers

import uz.abdurashidov.foodapp.data.local.models.FoodEntity
import uz.abdurashidov.foodapp.domain.models.Food

fun Food.toFoodEntity(): FoodEntity {
    return FoodEntity(
        foodId = foodId,
        foodName = foodName,
        foodImageURL = foodImageURL
    )
}