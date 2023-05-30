package com.hatidzheonbashieva.ktormovies.android.presentation.savedmoviesscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hatidzheonbashieva.ktormovies.android.components.MovieCard

@Composable
fun SavedMoviesScreen(
    savedMoviesViewModel: SavedMoviesViewModel = hiltViewModel()
) {
    val movies = savedMoviesViewModel.movies

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MovieCard(movies = movies.value, modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .clickable {
                    savedMoviesViewModel.deleteAllMovies()
                },
            text = "Delete all saved movies",
            textDecoration = TextDecoration.Underline,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}