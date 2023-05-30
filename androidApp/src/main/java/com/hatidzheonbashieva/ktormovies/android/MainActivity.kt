package com.hatidzheonbashieva.ktormovies.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hatidzheonbashieva.ktormovies.android.presentation.moviemainscreen.MoviesMainScreen
import com.hatidzheonbashieva.ktormovies.android.presentation.savedmoviesscreen.SavedMoviesScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            MyApplicationTheme {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MoviesMainScreen.route
                    ) {
                        composable(route = Screen.MoviesMainScreen.route) {
                            MoviesMainScreen(navController= navController)
                        }
                        composable(route = Screen.SavedMoviesScreen.route) {
                            SavedMoviesScreen()
                        }
                    }
                }
        }
    }
}