package com.example.upcoming.viewmodel

import com.example.data.models.Movies

internal enum class LoadState {
    Idle,
    Loading,
    Loaded,
    NoResults,
    Error
}

internal data class UpcomingState(
    val loadState: LoadState = LoadState.Idle,
    val movies: Movies = Movies.initial,
    val errorMessage: String? = null,
)