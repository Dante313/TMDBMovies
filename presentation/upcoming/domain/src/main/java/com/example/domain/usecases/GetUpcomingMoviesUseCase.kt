package com.example.domain.usecases

import com.example.domain.repositories.UpcomingRepository
import javax.inject.Inject

class GetUpcomingMoviesUseCase @Inject constructor(
//    private val upcomingRepository: UpcomingRepository
) {

    suspend operator fun invoke(nextPage: Int, limit: Int) {

    }
//        upcomingRepository.getUpcomingMovies(nextPage, limit)
}