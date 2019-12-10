package com.eeearl.hackernews.di

import com.eeearl.hackernews.presentation.newslist.NewsListViewModel
import com.eeearl.hackernews.repository.NewsListRepository
import com.eeearl.hackernews.repository.NewsListRepositoryContract
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

var NewsListModule = module {

    //
    viewModel { NewsListViewModel(get()) }

    single { NewsListRepository() as NewsListRepositoryContract }
}