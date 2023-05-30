package com.hatidzheonbashieva.ktormovies.domain

import com.hatidzheonbashieva.ktormovies.domain.Movie

interface MovieDataSource {
    suspend fun insertMovie(movie: Movie)
    suspend fun getAllMovies(): List<Movie>
    suspend fun deleteAllMovies()
}