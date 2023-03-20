package com.example.ui.viewmodel

import com.example.domain.repositories.UpcomingRepository
import com.example.domain.usecases.GetUpcomingMoviesUseCase
import com.example.mvi.Middleware
import com.example.resourcemanagers.lookup.StringLookup
import com.example.utils.fold
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class UpcomingMiddleware @Inject constructor(
    private val upcomingRepository: UpcomingRepository,
    private val stringLookup: StringLookup
) : Middleware<UpcomingState, UpcomingAction>() {

    override fun process(state: UpcomingState, action: UpcomingAction) {
        scope.launch {
            when (action) {
                UpcomingAction.LoadFirstPage -> loadUpcomingMovies()
                is UpcomingAction.LoadNewPage -> loadUpcomingMovies(action.nextPage, state.currentPage)
                else -> Unit
            }
        }
    }

    private suspend fun loadUpcomingMovies(
        nextPage: Int = 1,
        currentPage: Int = 1,
        limit: Int = 10
    ) {
        // Если "текущая" страница состояния равна "следующей" странице экшна - значит она перешла
        // в состояние следующей и нужно её наполнить данными с бэка
        if (nextPage == currentPage) {
            upcomingRepository.getUpcomingMovies(nextPage, limit).fold(
                onSuccess = { movies ->
                    dispatch(UpcomingAction.NewPageLoaded(movies.movies))
                },
                onFailure = {
                    dispatch(UpcomingAction.LoadError("error"))
                }
            )
        } else {
            dispatch(UpcomingAction.AllPagesLoaded)
        }
    }
}