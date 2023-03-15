package com.example.upcoming.viewmodel

import com.example.data.models.Movies
import com.example.mvi.Action
import com.example.mvi.State

internal enum class LoadState {
    Idle,
    Loading,
    Loaded,
    NoResults,
    Error
}

internal data class UpcomingState(
    val loadState: LoadState,
    val movies: Movies,
    val errorMessage: String?,
) : State {
    companion object {
        val initial = UpcomingState(
            loadState = LoadState.Idle,
            movies = Movies.initial,
            errorMessage = null
        )
    }
}

internal sealed interface UpcomingAction : Action {
    object Loading : UpcomingAction

    data class Loaded(val movies: Movies) : UpcomingAction

    data class LoadError(val message: String) : UpcomingAction

    object Retry : UpcomingAction

    data class NoResults(val message: String) : UpcomingAction
}