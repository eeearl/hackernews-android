package com.eeearl.hackernews.repository

import com.eeearl.hackernews.network.ApiClient

interface NewsListRepositoryContract {
    fun greeting(): String
}

class NewsListRepository(private val service: ApiClient): NewsListRepositoryContract {
    override fun greeting(): String {

        runBlocking {
    val a = service.newStories()
}


        //service.newStories().

            return "Hello World!!!!!!!"

    }
}