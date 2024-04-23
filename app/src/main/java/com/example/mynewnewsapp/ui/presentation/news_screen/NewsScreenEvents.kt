package com.example.mynewnewsapp.ui.presentation.news_screen

import com.example.mynewnewsapp.domain.model.Article

sealed class NewsScreenEvents {
    data class OnNewsCardClicked(var article: Article) : NewsScreenEvents()
    data class OnCategoryChanged(var category: String) : NewsScreenEvents()
    data class OnSearchQueryChanged(var searchQuery: String) : NewsScreenEvents()
    object OnSearchIconClicked: NewsScreenEvents()
    object OnCloseIconClicked: NewsScreenEvents()
}