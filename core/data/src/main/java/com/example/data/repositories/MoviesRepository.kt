package com.example.data.repositories

import com.example.data.models.Movies
import com.example.utils.Either

interface MoviesRepository {

    suspend fun getUpcomingMovies(page: Int, limit: Int): Either<Movies>
}