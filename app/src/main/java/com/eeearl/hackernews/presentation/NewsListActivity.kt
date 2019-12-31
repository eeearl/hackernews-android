package com.eeearl.hackernews.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.eeearl.R
import com.eeearl.databinding.ActivityMainBinding
import com.eeearl.hackernews.presentation.newslist.NewsListAdapter
import com.eeearl.hackernews.presentation.newslist.NewsListViewModel
import com.eeearl.hackernews.repository.NewsListRepositoryContract
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel by viewModel<NewsListViewModel>()
    val apiClient by inject<NewsListRepositoryContract>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        binding.viewModel = viewModel

        val adapter = NewsListAdapter(arrayListOf(), apiClient)
        binding.rvNews.adapter = adapter

        viewModel.topNews()
    }
}
