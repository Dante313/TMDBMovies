package com.example.domain.usecases

import com.example.domain.models.Movies
import com.example.domain.repositories.UpcomingRepository
import com.example.models.Either
import javax.inject.Inject

class GetUpcomingMoviesUseCase @Inject constructor(
    private val upcomingRepository: UpcomingRepository
) {

    suspend operator fun invoke(nextPage: Int, limit: Int): Either<Movies> {
        return upcomingRepository.getUpcomingMovies(nextPage, limit)
    }
}

