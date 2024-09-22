package com.example.erudiapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Song(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nomeObra: String,
    val compositor: String,
    val instrumentacao: String,
    val ano: Int,
    val genero: String
)
