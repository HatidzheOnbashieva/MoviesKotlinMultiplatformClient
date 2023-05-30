package com.hatidzheonbashieva.ktormovies.di

import com.hatidzheonbashieva.ktormovies.data.DatabaseDriverFactory
import com.hatidzheonbashieva.ktormovies.data.SqlDelightMovieDataSource
import com.hatidzheonbashieva.ktormovies.database.MovieDatabase
import com.hatidzheonbashieva.ktormovies.domain.MovieDataSource
import com.hatidzheonbashieva.ktormovies.remote.HttpClientFactory
import com.hatidzheonbashieva.ktormovies.domain.MovieService
import com.hatidzheonbashieva.ktormovies.remote.MovieClientImpl

class AppModule() {

    val movieDataSource: MovieDataSource by lazy {
        SqlDelightMovieDataSource(
            MovieDatabase(
                DatabaseDriverFactory().createDriver()
            )
        )
    }

    val movieClient: MovieService by lazy {
       MovieClientImpl(
            HttpClientFactory().create()
        )
    }
}