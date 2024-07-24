package uz.abdurashidov.foodapp.utils

sealed class DataState<out T> {
    data class Loading<out T>(val data: T? = null) : DataState<T>()
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exception: Throwable) : DataState<Nothing>()
}