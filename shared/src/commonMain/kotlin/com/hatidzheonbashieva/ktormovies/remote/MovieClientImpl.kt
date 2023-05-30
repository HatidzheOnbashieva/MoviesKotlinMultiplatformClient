package com.hatidzheonbashieva.ktormovies.remote

import com.hatidzheonbashieva.ktormovies.domain.Movie
import com.hatidzheonbashieva.ktormovies.domain.MovieService
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*

class MovieClientImpl(
    private val httpClient: HttpClient
) : MovieService {
    override suspend fun getMovies(): List<Movie> {
        return try {
            httpClient.get(HttpRoutes.MOVIES).body()
        } catch (e: RedirectResponseException) {
            //3xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        }
        catch (e: RedirectResponseException) {
            //4xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        }
        catch (e: RedirectResponseException) {
            //5xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        }
        catch (e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }
}
