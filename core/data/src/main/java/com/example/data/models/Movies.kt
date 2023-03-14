package com.example.data.models

import com.example.data.models.Result.Companion.toResult
import com.example.network.models.MoviesNetwork
import com.example.network.models.ResultNetwork
import java.util.Calendar

data class Movies(
    val entries: Int,
    val next: String,
    val page: Int,
    val results: List<Result>
) {
    companion object {
        fun MoviesNetwork.toMovies() = Movies(
            entries = this.entries,
            next = this.next,
            page = this.page,
            results = this.results.map { it.toResult() }
        )
    }
}

data class Result(
    val imageUrl: String,
    val releaseDate: Calendar,
    val releaseYear: Int,
    val title: String
) {
    companion object {
        fun ResultNetwork.toResult(): Result {
            val releaseCalendarDate = Calendar.getInstance()

            with(this.releaseDate) {
                releaseCalendarDate.set(year, month, day)
            }

            return Result(
                imageUrl = this.primaryImage.url,
                releaseDate = releaseCalendarDate,
                releaseYear = this.releaseYear.year,
                title = this.titleText.text
            )
        }
    }
}