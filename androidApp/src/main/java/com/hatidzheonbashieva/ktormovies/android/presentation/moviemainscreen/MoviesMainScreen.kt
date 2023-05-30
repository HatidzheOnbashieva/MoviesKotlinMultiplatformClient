package com.hatidzheonbashieva.ktormovies.android.presentation.moviemainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hatidzheonbashieva.ktormovies.android.components.MovieCard
import com.hatidzheonbashieva.ktormovies.android.Screen

@Composable
fun MoviesMainScreen(
    moviesMainViewModel: MoviesMainViewModel = hiltViewModel(),
    navController: NavController
) {
    val movies = moviesMainViewModel.movies
    val moviesToInsert = movies.value.take(3)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
        ) {
        Text(
            modifier = Modifier
                .padding(top = 8.dp, end = 16.dp)
                .align(End)
                .clickable {
                    for(movie in moviesToInsert){
                        moviesMainViewModel.insertMovie(movie)
                    }
                    navController.navigate(Screen.SavedMoviesScreen.route)
                },
            text = "To saved movies ->",
            textDecoration = TextDecoration.Underline,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(10.dp))
        
        MovieCard(movies = movies.value)
    }
}