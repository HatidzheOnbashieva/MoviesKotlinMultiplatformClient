package com.hatidzheonbashieva.ktormovies.android

sealed class Screen(val route: String) {
    object MoviesMainScreen : Screen("movies_main_screen")
    object SavedMoviesScreen : Screen("saved_movies_screen")
}
