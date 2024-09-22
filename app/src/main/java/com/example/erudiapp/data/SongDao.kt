package com.example.erudiapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SongDao {
    @Query("SELECT * FROM books")
    fun getAllSongs(): Flow<List<Song>>

    @Query("SELECT * FROM books WHERE id = :id")
    fun getSongById(id: Int): Flow<Song>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSong(song: Song)

    @Delete
    suspend fun deleteSong(song: Song)
}
