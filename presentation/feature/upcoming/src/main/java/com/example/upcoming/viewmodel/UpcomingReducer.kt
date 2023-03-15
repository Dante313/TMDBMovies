package com.example.upcoming.viewmodel

import com.example.mvi.Reducer
import javax.inject.Inject

internal class UpcomingReducer @Inject constructor() : Reducer<UpcomingState, UpcomingAction> {

    override fun reduce(state: UpcomingState, action: UpcomingAction): UpcomingState = when (action) {
        is UpcomingAction.Loading -> state.copy(
            loadState = LoadState.Loading
        )
        is UpcomingAction.Loaded -> state.copy(
            loadState = LoadState.Loaded,
            movies = action.movies
        )
        is UpcomingAction.LoadError -> state.copy(
            loadState = LoadState.Error,
            errorMessage = action.message
        )
        is UpcomingAction.NoResults -> state.copy(
            errorMessage = action.message
        )
        else -> state
    }
}