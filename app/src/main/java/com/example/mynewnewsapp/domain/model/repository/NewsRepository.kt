package com.example.mynewnewsapp.domain.model.repository

import com.example.mynewnewsapp.domain.model.Article
import com.example.mynewnewsapp.util.Resources

interface NewsRepository {
    suspend fun getTopHeadlines(category:String):Resources<List<Article>>
}