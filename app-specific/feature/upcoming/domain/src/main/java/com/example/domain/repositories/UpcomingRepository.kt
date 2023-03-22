package com.example.domain.repositories

import com.example.domain.models.Movies
import com.example.models.Either

interface UpcomingRepository {

    suspend fun getUpcomingMovies(page: Int, limit: Int): Either<Movies>
}