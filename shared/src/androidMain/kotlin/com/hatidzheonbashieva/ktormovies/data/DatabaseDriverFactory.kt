package com.hatidzheonbashieva.ktormovies.data

import android.content.Context
import com.hatidzheonbashieva.ktormovies.database.MovieDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(MovieDatabase.Schema, context, "movie.db")
    }
}