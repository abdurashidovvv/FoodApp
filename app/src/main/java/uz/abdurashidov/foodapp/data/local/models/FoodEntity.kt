package uz.abdurashidov.foodapp.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods")
data class FoodEntity(
    @PrimaryKey
    val foodId: String,
    val foodName: String,
    val foodImageURL: String
)