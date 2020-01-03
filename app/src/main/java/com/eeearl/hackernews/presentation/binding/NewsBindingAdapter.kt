package com.eeearl.hackernews.presentation.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eeearl.hackernews.presentation.newslist.NewsListAdapter
import com.eeearl.hackernews.repository.NewsItem

object NewsBindingAdapter {
    @JvmStatic
    @BindingAdapter("newsItems")
    fun RecyclerView.setList(list: List<NewsItem>) {
        val adapter = this.adapter as NewsListAdapter
        adapter.setList(list)
    }
}