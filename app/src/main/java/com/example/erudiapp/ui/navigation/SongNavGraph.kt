package com.example.erudiapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.erudiapp.ui.SongViewModelFactory
import com.example.erudiapp.ui.HomeScreen
import com.example.erudiapp.data.SongRepository
import com.example.erudiapp.ui.SongViewModel
import com.example.erudiapp.ui.SongScreen

@Composable
fun SongNavGraph(navController: NavHostController, songRepository: SongRepository) {
    val viewModel: SongViewModel = viewModel(factory = SongViewModelFactory(songRepository))

    NavHost(navController, startDestination = "homeScreen") {
        composable("homeScreen") { HomeScreen(navController) }
        composable("songScreen") { SongScreen(viewModel) }
    }
}
