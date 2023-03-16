package com.example.network

import com.example.network.models.MoviesNetwork
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RapidMoviesApi {

    @GET("/titles/x/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<MoviesNetwork>
}