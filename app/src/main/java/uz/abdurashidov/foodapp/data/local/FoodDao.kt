package uz.abdurashidov.foodapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.abdurashidov.foodapp.data.local.models.FoodEntity
import uz.abdurashidov.foodapp.domain.models.Food

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(foodEntity: FoodEntity)

    @Query("select * from foodentity")
    suspend fun getAllFavoriteFoods(): Flow<List<Food>>

    @Query("DELETE FROM foodentity WHERE foodId = :foodId")
    suspend fun deleteMealById(foodId: String)
}