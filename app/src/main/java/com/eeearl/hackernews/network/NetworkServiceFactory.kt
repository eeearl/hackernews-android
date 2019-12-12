package com.eeearl.hackernews.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit

object NetworkServiceFactory {

    fun service(baseUrl: String): ApiClient {
        var okHttpClient = makeOkHttpClient()
        return createHackerNewsService(baseUrl, okHttpClient)
    }

    private fun createHackerNewsService(baseUrl: String, okHttpClient: OkHttpClient): ApiClient {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
            .create(ApiClient::class.java)
    }

    private fun makeOkHttpClient() = OkHttpClient.Builder()
        //.addInterceptor(httpLoggingInterceptor)
        .build()
}

sealed class Result<out T: Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}