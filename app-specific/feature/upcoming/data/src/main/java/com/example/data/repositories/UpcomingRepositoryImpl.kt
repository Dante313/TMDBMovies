package com.example.data.repositories

import com.example.data.UpcomingApi
import com.example.data.models.MoviesNetwork.Companion.toMovies
import com.example.domain.models.Movies
import com.example.domain.repositories.UpcomingRepository
import com.example.network.safeApiCall
import com.example.utils.Either
import com.example.utils.fold
import kotlinx.coroutines.delay
import javax.inject.Inject

class UpcomingRepositoryImpl @Inject constructor(
    private val moviesApi: UpcomingApi
) : UpcomingRepository {

    override suspend fun getUpcomingMovies(page: Int, limit: Int): Either<Movies> {
        delay(500)
        return safeApiCall { moviesApi.getUpcomingMovies(page, limit) }.fold(
            onSuccess = {
                Either.Success(it.toMovies())
            },
            onFailure = {
                Either.Failure<Nothing>(it)
            }
        )
    }
}