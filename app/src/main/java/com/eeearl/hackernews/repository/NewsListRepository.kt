package com.eeearl.hackernews.repository

import com.eeearl.hackernews.network.ApiClient
import com.eeearl.hackernews.network.Result
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.*

interface NewsListRepositoryContract {
    suspend fun topNews(): List<Int>
    fun recentNews(): List<Int>
    suspend fun loadItem(id: Int, success: ((response: NewsItem) -> Unit)?)
}

class NewsListRepository(
    private val service: ApiClient, private val gson: Gson
): NewsListRepositoryContract {

    override suspend fun topNews(): List<Int> = coroutineScope {
        var list = mutableListOf<Int>()

        launch {
            val response = service.topStories()
            when (response.isSuccessful) {
                true -> gson.fromJson(response.body(), Array<Int>::class.java)
                    .iterator()
                    .forEach { list.add(it) }
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

    override suspend fun loadItem(id: Int, success: ((response: NewsItem) -> Unit)?) {
        coroutineScope {
            val response = service.loadItem(id)
            val item: NewsItem? = when (response.isSuccessful) {
                true -> gson.fromJson(response.body(), NewsItem::class.java)
                else -> null
            }

            success?.invoke(item!!)
        }

    }
}

data class NewsItem (
    @SerializedName("title") val _title: String,
    @SerializedName("id") val _id: String
    )