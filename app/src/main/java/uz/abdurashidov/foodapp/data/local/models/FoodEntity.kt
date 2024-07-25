package uz.abdurashidov.foodapp.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FoodEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var foodId: String,
    var foodName: String,
    var foodImageURL: String
)
