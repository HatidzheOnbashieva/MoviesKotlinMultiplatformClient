package com.hatidzheonbashieva.ktormovies.android.presentation.moviemainscreen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hatidzheonbashieva.ktormovies.domain.Movie
import com.hatidzheonbashieva.ktormovies.domain.MovieDataSource
import com.hatidzheonbashieva.ktormovies.domain.MovieService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesMainViewModel @Inject constructor(
    private val movieClient: MovieService,
    private val movieDataSource: MovieDataSource
): ViewModel() {

    private val _movies = mutableStateOf(emptyList<Movie>())
    val movies: MutableState<List<Movie>> = _movies

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            try {
               _movies.value = movieClient.getMovies()
            }catch (e: java.lang.Exception){
                Log.e("MoviesViewModel", "GetMovies: ", e)
            }
        }
    }

    fun insertMovie(movie: Movie) {
        viewModelScope.launch {
            try {
                movieDataSource.insertMovie(movie)
            }catch (e: java.lang.Exception){
                Log.e("MoviesViewModel", "InsertMovie: ", e)
            }
        }
    }
}