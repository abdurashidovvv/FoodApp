package uz.abdurashidov.foodapp.data.local.mappers

import uz.abdurashidov.foodapp.data.local.models.FoodEntity
import uz.abdurashidov.foodapp.domain.models.Food

fun FoodEntity.toFood(): Food {
    return Food(
        foodId = foodId,
        foodName = foodName,
        foodImageURL = foodImageURL
    )
}