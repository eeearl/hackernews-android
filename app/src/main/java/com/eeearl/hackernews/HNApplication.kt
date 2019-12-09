package com.eeearl.hackernews

import android.app.Application
import com.eeearl.hackernews.di.NewsListModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class HNApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@HNApplication)
            modules(
                listOf(NewsListModule)
            )
        }
    }
}