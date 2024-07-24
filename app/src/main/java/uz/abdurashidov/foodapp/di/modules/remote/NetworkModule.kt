package uz.abdurashidov.foodapp.di.modules.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.abdurashidov.foodapp.data.remote.FoodService
import uz.abdurashidov.foodapp.data.remote.repositories.FoodServiceRepositoryImpl
import uz.abdurashidov.foodapp.data.remote.source.FoodServiceDataSource
import uz.abdurashidov.foodapp.data.remote.source.FoodServiceDataSourceImpl
import uz.abdurashidov.foodapp.domain.repositories.FoodServiceRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideFoodService(retrofit: Retrofit): FoodService {
        return retrofit.create(FoodService::class.java)
    }

    @Provides
    @Singleton
    fun provideFoodServiceDataSource(foodService: FoodService): FoodServiceDataSource {
        return FoodServiceDataSourceImpl(foodService = foodService)
    }

    @Provides
    @Singleton
    fun provideRepository(foodServiceDataSource: FoodServiceDataSource): FoodServiceRepository {
        return FoodServiceRepositoryImpl(foodServiceDataSource = foodServiceDataSource)
    }

}