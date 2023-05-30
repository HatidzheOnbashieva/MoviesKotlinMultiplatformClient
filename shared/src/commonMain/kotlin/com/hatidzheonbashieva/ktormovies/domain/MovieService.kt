package com.hatidzheonbashieva.ktormovies.domain

import com.hatidzheonbashieva.ktormovies.domain.Movie

interface MovieService {
    suspend fun getMovies(): List<Movie>
}