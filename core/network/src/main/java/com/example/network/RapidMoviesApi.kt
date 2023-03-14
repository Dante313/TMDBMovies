package com.example.network

import com.example.network.models.MoviesNetwork
import retrofit2.Response
import retrofit2.http.GET

interface RapidMoviesApi {

    @GET("/titles/x/upcoming")
    suspend fun getUpcomingMovies(): Response<MoviesNetwork>
}