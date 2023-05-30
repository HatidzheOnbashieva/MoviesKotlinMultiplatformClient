package com.hatidzheonbashieva.ktormovies.android.presentation.savedmoviesscreen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hatidzheonbashieva.ktormovies.domain.Movie
import com.hatidzheonbashieva.ktormovies.domain.MovieDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedMoviesViewModel @Inject constructor(
    private val movieDataSource: MovieDataSource
): ViewModel() {

    private val _movies = mutableStateOf(emptyList<Movie>())
    val movies: MutableState<List<Movie>> = _movies

    init {
        getAllMovies()
    }

    private fun getAllMovies() {
        viewModelScope.launch {
            try {
                _movies.value = movieDataSource.getAllMovies()
            }catch (e: java.lang.Exception){
                Log.e("SavedMoviesViewModel", "GetAllMovies: ", e)
            }
        }
    }

    fun deleteAllMovies() {
        viewModelScope.launch {
            try {
                movieDataSource.deleteAllMovies()
                _movies.value = emptyList()
            }catch (e: java.lang.Exception){
                Log.e("SavedMoviesViewModel", "InsertMovie: ", e)
            }
        }
    }
}