package com.example.erudiapp.data

import kotlinx.coroutines.flow.Flow

open class SongRepository(private val songDao: SongDao) {
    fun getAllSongs(): Flow<List<Song>> = songDao.getAllSongs()

    fun getSongById(id: Int): Flow<Song> = songDao.getSongById(id)

    suspend fun insertSong(song: Song) = songDao.insertSong(song)

    suspend fun deleteSong(song: Song) = songDao.deleteSong(song)
}
