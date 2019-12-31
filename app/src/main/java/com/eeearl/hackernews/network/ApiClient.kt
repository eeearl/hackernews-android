package com.eeearl.hackernews.network

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("newstories.json?print=pretty")
    suspend fun newStories(): Response<JsonObject>

    @GET("askstories.json?print=pretty")
    suspend fun askStories(): List<Int>

    @GET("topstories.json?print=pretty")
    suspend fun topStories(): Response<JsonArray>

    @GET("jobstories.json?print=pretty")
    suspend fun jobStories(): List<Int>

    @GET("item/{id}.json?print=pretty")
    suspend fun loadItem(@Path("id") id: Int): Response<JsonObject>

    //@GET
    //suspend fun itemDetails(@Url url:String):Deferred<ItemModel>
}