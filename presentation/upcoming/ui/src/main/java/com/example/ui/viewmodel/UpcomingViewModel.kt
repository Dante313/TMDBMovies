package com.example.ui.viewmodel

import com.example.coroutines.CloseableCoroutineScope
import com.example.mvi.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class UpcomingViewModel @Inject constructor(
    closeableScope: CloseableCoroutineScope,
    reducer: UpcomingReducer,
    upcomingMiddleware: UpcomingMiddleware
) : MviViewModel<UpcomingState, UpcomingAction>(
    closeableScope = closeableScope,
    reducer = reducer,
    middlewares = listOf(upcomingMiddleware),
    initialState = UpcomingState.initial
) {

    init {
        handleAction(UpcomingAction.LoadFirstPage)
    }

    fun loadMore(nextPage: Int) {
        handleAction(UpcomingAction.LoadNewPage(nextPage))
    }
}