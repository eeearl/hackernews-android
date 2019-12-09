package com.eeearl.hackernews.presentation.newslist

import androidx.lifecycle.ViewModel
import com.eeearl.hackernews.repository.NewsListRepositoryContract

interface NewsListViewModelContract {
    fun greeting(): String
}

class NewsListViewModel(
    private val newsListRepo: NewsListRepositoryContract
) : ViewModel(), NewsListViewModelContract {

    override fun greeting(): String {
        return newsListRepo.greeting()
    }
}