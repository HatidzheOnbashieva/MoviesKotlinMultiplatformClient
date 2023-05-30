package com.hatidzheonbashieva.ktormovies.remote

import io.ktor.client.*

expect class HttpClientFactory {
    fun create(): HttpClient
}