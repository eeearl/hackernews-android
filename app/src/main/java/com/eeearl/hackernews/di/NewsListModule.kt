package com.eeearl.hackernews.di

import com.eeearl.hackernews.network.NetworkServiceFactory
import com.eeearl.hackernews.presentation.newslist.NewsListViewModel
import com.eeearl.hackernews.repository.NewsListRepository
import com.eeearl.hackernews.repository.NewsListRepositoryContract
import com.google.gson.GsonBuilder
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

var NewsListModule = module {

    //
    viewModel { NewsListViewModel(get()) }

    single { GsonBuilder().create() }
    single { NewsListRepository(get(), get()) as NewsListRepositoryContract }
    single { NetworkServiceFactory.service("https://hacker-news.firebaseio.com/v0/") }

}
