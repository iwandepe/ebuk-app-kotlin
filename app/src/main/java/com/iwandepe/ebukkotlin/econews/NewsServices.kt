package com.iwandepe.ebukkotlin.econews

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://newsapi.org"

interface NewsapiService {
    @GET("v2/top-headlines?category=health&apiKey=8c33489d96b2428ea4fcda483ccd71fd")
    fun getArticlesList(@Query("country") category: String): Call<NewsResponse>
}

data class Article(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)

data class NewsResponse (
    val articles: MutableList<Article>
)

object NewsSevices {

    fun create(): NewsapiService {
        val retrofit = Retrofit.Builder()
            // convert json to kotlin object
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(NewsapiService::class.java)
    }
}
