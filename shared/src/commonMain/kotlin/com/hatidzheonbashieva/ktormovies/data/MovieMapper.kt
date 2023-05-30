package com.hatidzheonbashieva.ktormovies.data

import com.hatidzheonbashieva.ktormovies.domain.Movie
import database.MovieEntity

fun MovieEntity.toMovie(): Movie {
    return Movie(
        movieId = movieId,
        movieName = movieName,
        movieOverview = movieOverview,
        movieGenre = movieGenre,
        movieImageUrl = movieImageUrl
    )
}