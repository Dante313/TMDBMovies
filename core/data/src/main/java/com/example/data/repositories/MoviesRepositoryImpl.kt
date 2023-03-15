package com.example.data.repositories

import com.example.data.models.Movies
import com.example.data.models.Movies.Companion.toMovies
import com.example.network.RapidMoviesApi
import com.example.network.safeApiCall
import com.example.utils.Either
import com.example.utils.fold
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesApi: RapidMoviesApi
) : MoviesRepository {

    override suspend fun getUpcomingMovies(): Either<Movies> {
        return safeApiCall { moviesApi.getUpcomingMovies(2, 10) }.fold(
            onSuccess = {
                Either.Success(it.toMovies())
            },
            onFailure = {
                Either.Failure<Nothing>(it)
            }
        )
    }
}