package com.eeearl.hackernews.repository

interface NewsListRepositoryContract {
    fun greeting(): String
}

class NewsListRepository: NewsListRepositoryContract {
    override fun greeting(): String {
        return "Hello World!!!!!!!"
    }
}