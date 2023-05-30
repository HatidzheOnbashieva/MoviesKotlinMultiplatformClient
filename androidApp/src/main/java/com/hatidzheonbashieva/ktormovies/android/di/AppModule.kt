package com.hatidzheonbashieva.ktormovies.android.di

import android.app.Application
import com.hatidzheonbashieva.ktormovies.data.DatabaseDriverFactory
import com.hatidzheonbashieva.ktormovies.data.SqlDelightMovieDataSource
import com.hatidzheonbashieva.ktormovies.database.MovieDatabase
import com.hatidzheonbashieva.ktormovies.domain.MovieDataSource
import com.hatidzheonbashieva.ktormovies.remote.HttpClientFactory
import com.hatidzheonbashieva.ktormovies.domain.MovieService
import com.hatidzheonbashieva.ktormovies.remote.MovieClientImpl
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClientFactory().create()
    }

    @Provides
    @Singleton
    fun provideMovieClient(httpClient: HttpClient): MovieService {
        return MovieClientImpl(httpClient)
    }

    @Provides
    @Singleton
    fun provideDatabaseDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideMovieDataSource(driver: SqlDriver): MovieDataSource {
        return SqlDelightMovieDataSource(MovieDatabase(driver))
    }
}