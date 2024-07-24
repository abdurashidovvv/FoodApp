package uz.abdurashidov.foodapp.data.remote.mappers

import uz.abdurashidov.foodapp.data.remote.models.GetMealsByCategoryResponse
import uz.abdurashidov.foodapp.domain.models.Food

fun GetMealsByCategoryResponse.toListFood(): List<Food> {
    val foodList = ArrayList<Food>()
    for (meal in this.meals) {
        foodList.add(
            Food(
                foodId = meal.idMeal,
                foodName = meal.strMeal,
                foodImageURL = meal.strMealThumb
            )
        )
    }
    return foodList
}