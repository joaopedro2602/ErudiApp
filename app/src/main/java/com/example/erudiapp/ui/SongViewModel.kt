package com.example.erudiapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.erudiapp.data.SongRepository
import com.example.erudiapp.data.Song
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class SongViewModel(private val repository: SongRepository) : ViewModel() {

    val songList: Flow<List<Song>> = repository.getAllSongs()

    fun getBookById(id: Int): Flow<Song> = repository.getSongById(id)

    fun addOrUpdateBook(id: Int? = null, title: String, pub_year: Int, author: String, genre: String, publisher: String) {
        val song = Song(id = id ?: 0, nomeObra = title,  ano = pub_year, compositor = author, instrumentacao = genre, genero = publisher)
        viewModelScope.launch {
            repository.insertSong(song)
        }
    }

    fun deleteBook(song: Song) {
        viewModelScope.launch {
            repository.deleteSong(song)
        }
    }
}
