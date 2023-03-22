package com.example.domain.models

import java.util.*

data class Movies(
    val entries: Int,
    val next: String,
    val page: Int,
    val movies: List<Movie>
) {
    companion object {
        val initial = Movies(
            entries = 0,
            next = "",
            page = -1,
            movies = listOf()
        )
    }
}

data class Movie(
    val id: String,
    val imageUrl: String?,
    val releaseDate: Calendar,
    val releaseYear: String,
    val title: String
)