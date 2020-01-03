package com.eeearl.hackernews.presentation.newslist

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eeearl.hackernews.repository.NewsItem
import com.eeearl.hackernews.repository.NewsListRepositoryContract
import kotlinx.coroutines.launch

interface NewsListViewModelContract {
    fun topNews()
    fun recentNews()
}

class NewsListViewModel(
    private val newsListRepo: NewsListRepositoryContract
) : ViewModel(), NewsListViewModelContract {

    val mNewsList: ObservableArrayList<NewsItem> = ObservableArrayList()

    override fun topNews() {
        viewModelScope.launch {
            mNewsList.addAll(newsListRepo.topNews())
        }
    }

    override fun recentNews() {
//        mNewsList.addAll(newsListRepo.recentNews())
    }
}