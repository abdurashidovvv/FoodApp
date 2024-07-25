package uz.abdurashidov.foodapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.abdurashidov.foodapp.data.local.models.FoodEntity

@Database(entities = [FoodEntity::class], version = 1)
abstract class FoodDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao
}