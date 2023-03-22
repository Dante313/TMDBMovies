package com.example.data.repositories

import com.example.data.UpcomingApi
import com.example.data.models.MoviesNetwork.Companion.toMovies
import com.example.domain.models.Movies
import com.example.domain.repositories.UpcomingRepository
import com.example.errors.ErrorHandler
import com.example.models.Either
import com.example.models.fold
import com.example.network.safeApiCall
import kotlinx.coroutines.delay
import javax.inject.Inject

class UpcomingRepositoryImpl @Inject constructor(
    private val moviesApi: UpcomingApi,
    private val errorHandler: ErrorHandler
) : UpcomingRepository {

    override suspend fun getUpcomingMovies(page: Int, limit: Int): Either<Movies> {
        delay(500)
        return safeApiCall(errorHandler) { moviesApi.getUpcomingMovies(page, limit) }.fold(
            onSuccess = {
                Either.Success(it.toMovies())
            },
            onFailure = {
                Either.Failure<Nothing>(it)
            }
        )
    }
}