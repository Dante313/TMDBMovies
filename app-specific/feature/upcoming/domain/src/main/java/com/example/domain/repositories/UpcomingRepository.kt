package com.example.domain.repositories

import com.example.domain.models.Movies
import com.example.utils.Either
import javax.inject.Singleton

@Singleton
interface UpcomingRepository {

    suspend fun getUpcomingMovies(page: Int, limit: Int): Either<Movies>
}