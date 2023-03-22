package com.example.ui.viewmodel

import com.example.errors.ErrorEntity
import com.example.mvi.Reducer
import javax.inject.Inject

internal class UpcomingReducer @Inject constructor() : Reducer<UpcomingState, UpcomingAction> {

    override fun reduce(state: UpcomingState, action: UpcomingAction): UpcomingState = when (action) {
        is UpcomingAction.LoadFirstPage -> state.copy(
            loadState = LoadState.LoadFirstPage,
            isLoading = true
        )
        is UpcomingAction.NewPageLoaded -> {
            if (action.movies.size < 10) {
                // Если размер данных < 10 значит это последняя страница и больше их нет
                state.copy(
                    loadState = LoadState.AllPagesLoaded,
                    nextPage = null,
                    isLoading = false
                )
            } else {
                // Если размер данных = 10, значит мы не на последней странице и впереди есть ещё одна
                state.copy(
                    loadState = LoadState.NextPageLoaded,
                    movies = state.movies + action.movies,
                    nextPage = state.currentPage.inc(),
                    isLoading = false
                )
            }
        }
        is UpcomingAction.LoadNewPage -> {
            // Если необходимо загрузить новую страницу - значит "текущая" страница переходит в состояние "следующей"
            state.copy(isLoading = true, currentPage = state.nextPage ?: state.currentPage)
        }
        is UpcomingAction.LoadError -> {
            val errorMessage = when(action.error) {
                is ErrorEntity.Network -> action.error.msg ?: "No Internet connection :("
                ErrorEntity.AccessDenied -> "Access denied!"
                ErrorEntity.ServiceUnavailable -> "Looks like service is not available"
                ErrorEntity.NotFound -> "Page is not found :("
                ErrorEntity.Unknown -> "Something went wrong!"
            }
            state.copy(
                loadState = LoadState.Error,
                errorMessage = errorMessage,
                isLoading = false
            )
        }
        else -> state
    }
}