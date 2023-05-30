package com.hatidzheonbashieva.ktormovies.data

import com.hatidzheonbashieva.ktormovies.database.MovieDatabase
import com.hatidzheonbashieva.ktormovies.domain.Movie
import com.hatidzheonbashieva.ktormovies.domain.MovieDataSource

class SqlDelightMovieDataSource(
    database: MovieDatabase
) : MovieDataSource {
    private val queries = database.movieDatabaseQueries

    override suspend fun insertMovie(movie: Movie) {
        queries.insertMovie(
            movieId = movie.movieId,
            movieName = movie.movieName,
            movieOverview = movie.movieOverview,
            movieGenre = movie.movieGenre,
            movieImageUrl = movie.movieImageUrl
        )
    }

    override suspend fun getAllMovies(): List<Movie> {
        return queries
            .getAllMovies()
            .executeAsList()
            .map { it.toMovie() }
    }

    override suspend fun deleteAllMovies() {
        queries.deleteAllMovies()
    }
}