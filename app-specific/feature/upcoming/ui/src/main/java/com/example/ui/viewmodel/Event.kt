package com.example.ui.viewmodel

import com.example.domain.models.Movie
import com.example.errors.ErrorEntity
import com.example.mvi.Action
import com.example.mvi.State

internal enum class LoadState {
    Idle,
    LoadFirstPage,
    NextPageLoaded,
    AllPagesLoaded,
    Error
}

internal data class UpcomingState(
    val loadState: LoadState,
    val movies: List<Movie>,
    val nextPage: Int?,
    val currentPage: Int,
    val errorMessage: String?,
    val isLoading: Boolean
) : State {

    companion object {
        val initial = UpcomingState(
            loadState = LoadState.Idle,
            movies = listOf(),
            nextPage = 1,
            currentPage = 1,
            errorMessage = null,
            isLoading = false
        )
    }
}

internal sealed interface UpcomingAction : Action {

    object LoadFirstPage : UpcomingAction

    object AllPagesLoaded : UpcomingAction

    data class NewPageLoaded(val movies: List<Movie>) : UpcomingAction

    data class LoadNewPage(val nextPage: Int) : UpcomingAction

    data class LoadError(val error: ErrorEntity) : UpcomingAction
}