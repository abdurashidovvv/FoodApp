package uz.abdurashidov.foodapp.data.remote.mappers

import uz.abdurashidov.foodapp.data.remote.models.GetFoodByFoodId.Meal
import uz.abdurashidov.foodapp.domain.models.MealDetail

fun Meal.toMealDetail(): MealDetail {
    val ingredients = ArrayList<Map<String, String>>()
    ingredients.add(mapOf(this.strIngredient1 to this.strMeasure1))
    ingredients.add(mapOf(this.strIngredient2 to this.strMeasure2))
    ingredients.add(mapOf(this.strIngredient3 to this.strMeasure3))
    ingredients.add(mapOf(this.strIngredient4 to this.strMeasure4))
    ingredients.add(mapOf(this.strIngredient5 to this.strMeasure5))
    ingredients.add(mapOf(this.strIngredient6 to this.strMeasure6))
    ingredients.add(mapOf(this.strIngredient7 to this.strMeasure7))
    ingredients.add(mapOf(this.strIngredient8 to this.strMeasure8))
    ingredients.add(mapOf(this.strIngredient9 to this.strMeasure9))
    return MealDetail(
        foodName = this.strMeal,
        ingredientList = ingredients,
        instruction = this.strInstructions,
        foodImageURL = strMealThumb,
        foodArea = strArea,
        youTubeLink = strYoutube
    )
}