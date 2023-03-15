package com.example.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
)

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
)

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