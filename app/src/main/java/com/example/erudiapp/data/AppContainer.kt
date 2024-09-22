package com.example.erudiapp.data

import android.content.Context
import androidx.room.Room

class AppContainer(context: Context) {
    private val database: SongDatabase by lazy {
        Room.databaseBuilder(context, SongDatabase::class.java, "bd_music").build()
    }

    val songRepository: SongRepository by lazy {
        SongRepository(database.songDao())
    }
}