package com.example.mynewnewsapp.data.remote

import com.example.mynewnewsapp.domain.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi{
    //  https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=d99dadd7c17048ddbb77bf5feb057fce
    //https://newsapi.org/v2/top-headlines?country=us&apiKey=d99dadd7c17048ddbb77bf5feb057fce

    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("category")category:String,
        @Query("country")country:String="in",
        @Query("apiKey")apiKey:String= API_KEY
    ):NewsResponse

    companion object{
        const val API_KEY="d99dadd7c17048ddbb77bf5feb057fce"
        const val BASE_URL="https://newsapi.org/v2/"
    }
}