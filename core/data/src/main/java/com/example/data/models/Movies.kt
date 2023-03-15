package com.example.data.models

import com.example.data.models.Movie.Companion.toResult
import com.example.network.models.MoviesNetwork
import com.example.network.models.ResultNetwork
import java.util.Calendar

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

        fun MoviesNetwork.toMovies() = Movies(
            entries = this.entries,
            next = this.next,
            page = this.page,
            movies = this.results.map { it.toResult() }
        )
    }
}

data class Movie(
    val imageUrl: String?,
    val releaseDate: Calendar,
    val releaseYear: String,
    val title: String
) {
    companion object {
        fun ResultNetwork.toResult(): Movie {
            val releaseCalendarDate = Calendar.getInstance()

            with(this.releaseDate) {
                releaseCalendarDate.set(year, month, day)
            }

            return Movie(
                imageUrl = this.primaryImage?.url,
                releaseDate = releaseCalendarDate,
                releaseYear = this.releaseYear?.year.toString(),
                title = this.titleText.text
            )
        }
    }
}