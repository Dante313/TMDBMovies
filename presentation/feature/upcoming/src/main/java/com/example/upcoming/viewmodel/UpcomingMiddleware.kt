package com.example.upcoming.viewmodel

import com.example.data.repositories.MoviesRepository
import com.example.mvi.Middleware
import com.example.resourcemanagers.lookup.StringLookup
import com.example.utils.fold
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class UpcomingMiddleware @Inject constructor(
    private val moviesRepository: MoviesRepository,
    private val stringLookup: StringLookup
) : Middleware<UpcomingState, UpcomingAction>() {

    override fun process(state: UpcomingState, action: UpcomingAction) {
        when (action) {
            UpcomingAction.Load -> {
                scope.launch {
                    loadUpcomingMovies()
                }
            }
            else -> Unit
        }
    }

    private suspend fun loadUpcomingMovies() {
        dispatch(UpcomingAction.Loading)
        moviesRepository.getUpcomingMovies().fold(
            onSuccess = { movies ->
                if (movies.movies.isEmpty()) {
                    dispatch(UpcomingAction.NoResults("no results"))
                } else {
                    dispatch(UpcomingAction.Loaded(movies))
                }
            },
            onFailure = {
                dispatch(UpcomingAction.LoadError("error"))
            }
        )
    }
}