package com.eeearl.hackernews.di

import com.eeearl.hackernews.presentation.newslist.NewsListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

var NewsListModule = module {

    //
    viewModel { NewsListViewModel(get()) }
}