package uz.abdurashidov.foodapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.foodapp.data.local.models.FoodEntity
import uz.abdurashidov.foodapp.domain.models.Food

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFood(foodEntity: FoodEntity)

    @Query("SELECT * FROM foods")
    fun getAllFavoriteFoods(): Flow<List<FoodEntity>>

    @Query("DELETE FROM foods WHERE foodId = :foodId")
    fun deleteFoodById(foodId: String): Int
}