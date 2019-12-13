package com.eeearl.hackernews.presentation.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eeearl.hackernews.presentation.newslist.NewsListAdapter

object NewsBindingAdapter {
    @JvmStatic
    @BindingAdapter("newsItems")
    fun RecyclerView.setList(list: List<Int>) {
        val adapter = this.adapter as NewsListAdapter
        adapter.setList(list)
    }
}