package com.example.mynewnewsapp.ui.presentation.news_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewnewsapp.domain.model.Article
import com.example.mynewnewsapp.domain.model.repository.NewsRepository
import com.example.mynewnewsapp.util.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NewsScreenViewModel @Inject constructor(private val newsRepository: NewsRepository):ViewModel() {
    var state by mutableStateOf(NewsScreenState())

   // var articles by mutableStateOf<List<Article>>(emptyList())
   /* init {
        getNewsArticles(category = "general")
    }*/

    fun onEvent(event:NewsScreenEvents){
        when(event){
            is NewsScreenEvents.OnCategoryChanged -> {
                state = state.copy(category = event.category)
                getNewsArticles(category = state.category)
            }
            NewsScreenEvents.OnCloseIconClicked -> TODO()
            is NewsScreenEvents.OnNewsCardClicked -> {
                state = state.copy(selectedArticle = event.article)
            }
            NewsScreenEvents.OnSearchIconClicked -> TODO()
            is NewsScreenEvents.OnSearchQueryChanged -> TODO()
        }
    }

    private fun getNewsArticles(category:String){
        state=state.copy(isLoading = true)
        viewModelScope.launch {
            val result=newsRepository.getTopHeadlines(category=category)
            when (result){
                is Resources.Success ->{
                    state=state.copy(
                        articles = result.data?: emptyList(),
                        isLoading = false,
                        error = null

                    )
                }
                is Resources.Error -> {
                    state=state.copy(
                        articles = emptyList(),
                        isLoading = false,
                        error =result.message


                    )
                }

            }
        }
    }

}