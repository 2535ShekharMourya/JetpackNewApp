package com.example.mynewnewsapp.di

import com.example.mynewnewsapp.data.remote.NewsApi
import com.example.mynewnewsapp.data.remote.NewsApi.Companion.BASE_URL
import com.example.mynewnewsapp.data.remote.repository2.NewsRepositoryImpl
import com.example.mynewnewsapp.domain.model.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNewsApi():NewsApi{
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun ProvideNewsRepository(newApi:NewsApi):NewsRepository{
        return NewsRepositoryImpl(newApi=newApi)
    }
}