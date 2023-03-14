package com.example.network.models

import kotlinx.serialization.Serializable

@Serializable
data class MoviesNetwork(
    val entries: Int,
    val next: String,
    val page: Int,
    val results: List<ResultNetwork>
)

@Serializable
data class ResultNetwork(
    val id: String,
    val primaryImage: PrimaryImageNetwork,
    val releaseDate: ReleaseDateNetwork,
    val releaseYear: ReleaseYearNetwork,
    val titleText: TitleTextNetwork
)

@Serializable
data class PrimaryImageNetwork(val url: String)

@Serializable
data class ReleaseDateNetwork(
    val day: Int,
    val month: Int,
    val year: Int
)

@Serializable
data class ReleaseYearNetwork(val year: Int)

@Serializable
data class TitleTextNetwork(val text: String)