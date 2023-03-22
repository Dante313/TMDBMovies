package com.example.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetails(
    @SerialName("results")
    val results: Results
) {

    @Serializable
    data class Results(
        @SerialName("id")
        val id: String,
        @SerialName("primaryImage")
        val primaryImage: PrimaryImage,
        @SerialName("releaseDate")
        val releaseDate: ReleaseDate,
        @SerialName("releaseYear")
        val releaseYear: ReleaseYear,
        @SerialName("titleText")
        val titleText: TitleText,
    )

    @Serializable
    data class PrimaryImage(
        val url: String
    )

    @Serializable
    data class ReleaseDate(
        @SerialName("day")
        val day: Int,
        @SerialName("month")
        val month: Int,
        @SerialName("year")
        val year: Int
    )

    @Serializable
    data class ReleaseYear(
        @SerialName("year")
        val year: Int
    )

    @Serializable
    data class TitleText(
        @SerialName("text")
        val text: String
    )
}