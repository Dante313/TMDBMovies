package com.example.data.repositories

import com.example.data.models.Movies
import com.example.network.utils.Either

interface MoviesRepository {

    suspend fun getUpcomingMovies(): Either<Movies>
}