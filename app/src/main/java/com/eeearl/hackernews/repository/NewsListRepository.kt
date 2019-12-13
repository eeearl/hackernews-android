package com.eeearl.hackernews.repository

import com.eeearl.hackernews.network.ApiClient
import com.google.gson.Gson
import kotlinx.coroutines.*

interface NewsListRepositoryContract {
    suspend fun topNews(): List<Int>
    fun recentNews(): List<Int>
}

class NewsListRepository(
    private val service: ApiClient, private val gson: Gson
): NewsListRepositoryContract {

    override suspend fun topNews(): List<Int> = coroutineScope {
        var list = mutableListOf<Int>()

        launch {
            val response = service.topStories()
            when (response.isSuccessful) {
                true -> gson.fromJson(response.body(), Array<Int>::class.java).iterator().forEach { list.add(it) } //response.body(). .let { it as Array<Int> }.asIterable().forEach { list.add(it) }
            }
        }

        list
    }

    override fun recentNews(): List<Int> {
        var list = mutableListOf<Int>()

        CoroutineScope(Dispatchers.IO).launch {
            val response = service.newStories()
            when (response.isSuccessful) {
                true -> response.body().let { it as Array<Int> }.asIterable().forEach { list.add(it) }
            }
        }

        return list
    }
}