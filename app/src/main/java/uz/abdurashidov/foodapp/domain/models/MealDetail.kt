package uz.abdurashidov.foodapp.domain.models

data class MealDetail(
    var foodName:String,
    var ingredientList:List<Map<String, String>>,
    var instruction:String,
    var foodImageURL:String,
    var foodArea:String,
    var youTubeLink:String
)