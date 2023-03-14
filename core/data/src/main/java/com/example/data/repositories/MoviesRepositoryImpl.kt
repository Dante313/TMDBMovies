package com.example.data.repositories

import com.example.data.models.Movies
import com.example.data.models.Movies.Companion.toMovies
import com.example.network.RapidMoviesApi
import com.example.network.utils.Either
import com.example.network.utils.fold
import com.example.network.utils.safeApiCall
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesApi: RapidMoviesApi
) : MoviesRepository {

    override suspend fun getUpcomingMovies(): Either<Movies> {
        return safeApiCall { moviesApi.getUpcomingMovies() }.fold(
            onSuccess = {
                Either.Success(it.toMovies())
            },
            onFailure = {
                Either.Failure<Nothing>(it)
            }
        )
    }
}