package com.example.data

import com.example.data.models.MovieDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsApi {

    @GET("/titles/{id}")
    fun getMoviesDetails(@Path("id") movieId: String) : Response<MovieDetails>
}