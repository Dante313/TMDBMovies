package com.example.data.repositories

import com.example.data.models.Movies
import com.example.data.models.Movies.Companion.toMovies
import com.example.network.RapidMoviesApi
import com.example.network.safeApiCall
import com.example.utils.Either
import com.example.utils.fold
import kotlinx.coroutines.delay
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesApi: RapidMoviesApi
) : MoviesRepository {

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