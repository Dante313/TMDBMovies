package com.example.ui.viewmodel

import com.example.mvi.Reducer
import logcat.logcat
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
        is UpcomingAction.LoadError -> state.copy(
            loadState = LoadState.Error,
            errorMessage = action.message,
            isLoading = false
        )
        else -> state
    }
}