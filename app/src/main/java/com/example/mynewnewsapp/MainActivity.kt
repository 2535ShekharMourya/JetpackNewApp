package com.example.mynewnewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.mynewnewsapp.ui.presentation.MyNewNewsAppTheme
import com.example.mynewnewsapp.ui.presentation.news_screen.NewsScreen
import com.example.mynewnewsapp.ui.presentation.news_screen.NewsScreenViewModel
import com.example.mynewnewsapp.util.NavGraphSetup
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNewNewsAppTheme {
                val navController = rememberNavController()
                NavGraphSetup(navController = navController)
               /* val viewModel:NewsScreenViewModel= hiltViewModel()
                NewsScreen(
                    state=viewModel.state,
                    onEvent=viewModel::onEvent
                )*/
                // A surface container using the 'background' color from the theme

            }
        }
    }
}

