package uz.abdurashidov.foodapp.di.modules.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.abdurashidov.foodapp.data.local.FoodDao
import uz.abdurashidov.foodapp.data.local.FoodDatabase
import uz.abdurashidov.foodapp.data.local.repositories.LocalFoodRepositoryImpl
import uz.abdurashidov.foodapp.data.local.source.FoodLocalSource
import uz.abdurashidov.foodapp.data.local.source.FoodLocalSourceImpl
import uz.abdurashidov.foodapp.domain.repositories.LocalFoodRepository
import uz.abdurashidov.foodapp.domain.usecases.AddFavoriteFood.AddFavoriteFoodUseCase
import uz.abdurashidov.foodapp.domain.usecases.AddFavoriteFood.AddFavoriteFoodUseCaseImpl
import uz.abdurashidov.foodapp.domain.usecases.DeleteFavoriteFood.DeleteFavoriteFoodUseCase
import uz.abdurashidov.foodapp.domain.usecases.DeleteFavoriteFood.DeleteFavoriteFoodUseCaseImpl
import uz.abdurashidov.foodapp.domain.usecases.GetFavoriteFood.GetFavoriteFoodUseCase
import uz.abdurashidov.foodapp.domain.usecases.GetFavoriteFood.GetFavoriteFoodUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    fun provideFoodDatabase(@ApplicationContext context: Context): FoodDatabase {
        return Room.databaseBuilder(
            context,
            FoodDatabase::class.java,
            "quran_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideFoodDao(foodDatabase: FoodDatabase): FoodDao = foodDatabase.foodDao()

    @Provides
    @Singleton
    fun provideFoodLocalSource(foodDao: FoodDao): FoodLocalSource {
        return FoodLocalSourceImpl(foodDao)
    }

    @Provides
    @Singleton
    fun provideLocalFoodRepository(foodLocalSource: FoodLocalSource): LocalFoodRepository {
        return LocalFoodRepositoryImpl(foodLocalSource = foodLocalSource)
    }

    @Provides
    @Singleton
    fun provideAddFavoriteFoodUseCase(localFoodRepository: LocalFoodRepository): AddFavoriteFoodUseCase {
        return AddFavoriteFoodUseCaseImpl(localFoodRepository = localFoodRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteFavoriteFoodUseCase(localFoodRepository: LocalFoodRepository): DeleteFavoriteFoodUseCase {
        return DeleteFavoriteFoodUseCaseImpl(localFoodRepository = localFoodRepository)
    }

    @Provides
    @Singleton
    fun provideGetFavoriteFoodUseCase(localFoodRepository: LocalFoodRepository): GetFavoriteFoodUseCase {
        return GetFavoriteFoodUseCaseImpl(localFoodRepository = localFoodRepository)
    }
}