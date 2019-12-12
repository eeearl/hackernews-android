package com.eeearl.hackernews.network

import retrofit2.http.GET
import retrofit2.http.Url

interface ApiClient {

    @GET("newstories.json?print=pretty")
    suspend fun newStories(): List<Int>

    @GET("askstories.json?print=pretty")
    suspend fun askStories(): List<Int>

    @GET("topstories.json?print=pretty")
    suspend fun topStories(): List<Int>

    @GET("jobstories.json?print=pretty")
    suspend fun jobStories(): List<Int>

    //@GET
    //suspend fun itemDetails(@Url url:String):Deferred<ItemModel>
}