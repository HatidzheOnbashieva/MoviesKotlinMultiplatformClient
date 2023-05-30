package com.hatidzheonbashieva.ktormovies.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    @SerialName("movieId")
    val movieId: Long,
    @SerialName("movieName")
    val movieName: String,
    @SerialName("movieOverview")
    val movieOverview: String,
    @SerialName("movieGenre")
    val movieGenre: String,
    @SerialName("movieImageUrl")
    val movieImageUrl: String
)