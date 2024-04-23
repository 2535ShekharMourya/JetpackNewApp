package com.example.mynewnewsapp.data.remote.repository2

import com.example.mynewnewsapp.data.remote.NewsApi
import com.example.mynewnewsapp.domain.model.Article
import com.example.mynewnewsapp.domain.model.repository.NewsRepository
import com.example.mynewnewsapp.util.Resources
import java.lang.Exception

class NewsRepositoryImpl(private val newApi:NewsApi):NewsRepository {
    override suspend fun getTopHeadlines(category: String): Resources<List<Article>> {
        return try {
            val responce=newApi.getBreakingNews(category=category)
            Resources.Success(data = responce.articles)
        }catch (e:Exception){
            Resources.Error(message = "Failed to fetch news ${e.message}")
        }
    }
}