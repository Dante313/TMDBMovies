package com.example.data.models

import com.example.data.models.ResultNetwork.Companion.toResult
import com.example.domain.models.Movie
import com.example.domain.models.Movies
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class MoviesNetwork(
    @SerialName("entries")
    val entries: Int,
    @SerialName("next")
    val next: String,
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val results: List<ResultNetwork>
) {
    companion object {
        fun MoviesNetwork.toMovies() = Movies(
            entries = this.entries,
            next = this.next,
            page = this.page,
            movies = this.results.map { it.toResult() }
        )
    }
}

@Serializable
data class ResultNetwork(
    @SerialName("id")
    val id: String,
    @SerialName("primaryImage")
    val primaryImage: PrimaryImageNetwork?,
    @SerialName("releaseDate")
    val releaseDate: ReleaseDateNetwork,
    @SerialName("releaseYear")
    val releaseYear: ReleaseYearNetwork?,
    @SerialName("titleText")
    val titleText: TitleTextNetwork,
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

@Serializable
data class PrimaryImageNetwork(
    @SerialName("url")
    val url: String,
)

@Serializable
data class ReleaseDateNetwork(
    @SerialName("day")
    val day: Int,
    @SerialName("month")
    val month: Int,
    @SerialName("year")
    val year: Int
)

@Serializable
data class ReleaseYearNetwork(
    @SerialName("year")
    val year: Int
)

@Serializable
data class TitleTextNetwork(
    @SerialName("text")
    val text: String,
)