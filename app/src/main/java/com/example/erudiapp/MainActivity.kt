package com.example.erudiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.erudiapp.data.AppContainer
import com.example.erudiapp.ui.navigation.SongNavGraph
import com.example.erudiapp.ui.theme.ErudiAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ErudiAppTheme{
                val appContainer = AppContainer(applicationContext)
                val bookRepository = appContainer.songRepository
                val navController = rememberNavController()
                SongNavGraph(navController = navController, songRepository = bookRepository)            }
        }
    }
}
