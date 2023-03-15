package com.example.data.repositories

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.models.Movie
import com.example.data.models.Movie.Companion.toResult
import com.example.network.RapidMoviesApi
import com.example.network.safeApiCall
import com.example.utils.fold

class UpcomingPagingSource(
    private val moviesApi: RapidMoviesApi,
    private val pageSize: Int
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val pageIndex = params.key ?: 1

        return safeApiCall {
            moviesApi.getUpcomingMovies(pageIndex, params.loadSize)
        }.fold(
            onSuccess = { moviesNetwork ->
                val upcomingMovies = moviesNetwork.results.map { it.toResult() }

                LoadResult.Page(
                    data = upcomingMovies,
                    prevKey = if (pageIndex == 1) null else pageIndex - 1,
                    nextKey = if (upcomingMovies.size == params.loadSize) {
                        pageIndex + (params.loadSize / pageSize)
                    } else {
                        null
                    }
                )
            },
            onFailure = { throwable ->
                LoadResult.Error(throwable)
            }
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }
}