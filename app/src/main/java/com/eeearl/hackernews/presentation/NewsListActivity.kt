package com.eeearl.hackernews.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.eeearl.R
import com.eeearl.databinding.ActivityMainBinding
import com.eeearl.hackernews.presentation.newslist.NewsListViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel by viewModel<NewsListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        binding.viewModel = viewModel

        binding.tvSample.text = viewModel.greeting()

    }
}
