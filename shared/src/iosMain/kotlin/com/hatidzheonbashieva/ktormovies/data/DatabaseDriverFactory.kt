package com.hatidzheonbashieva.ktormovies.data

import com.hatidzheonbashieva.ktormovies.database.MovieDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(MovieDatabase.Schema, "movie.db")
    }
}