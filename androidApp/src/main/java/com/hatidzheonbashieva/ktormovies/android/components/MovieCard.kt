package com.hatidzheonbashieva.ktormovies.android.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hatidzheonbashieva.ktormovies.domain.Movie

@Composable
fun MovieCard(
    movies: List<Movie>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .padding(16.dp)
    ) {
        items(movies) { movie ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(10.dp),
                backgroundColor = Color(0xFFF0F0F0),
                elevation = 3.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    AsyncImage(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        model = movie.movieImageUrl,
                        contentDescription = "movie_image"
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = movie.movieName,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = movie.movieOverview,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.size(5.dp))
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append("Genre: ")
                            }
                            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                                append(movie.movieGenre)
                            }
                        }
                    )
                }
            }
        }
    }
}