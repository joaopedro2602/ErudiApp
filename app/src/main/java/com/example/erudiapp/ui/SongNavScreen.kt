package com.example.erudiapp.ui

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SongScreen(viewModel: SongViewModel) {
    var nome by remember { mutableStateOf("") }
    var compositor by remember { mutableStateOf("") }
    var instrumentacao by remember { mutableStateOf("") }
    var pub_year by remember { mutableStateOf("") }
    var genre by remember { mutableStateOf("") }
    var selectedSongId by remember { mutableStateOf<Int?>(null) }

    val songList by viewModel.songList.collectAsState(initial = emptyList())

    val isFormValid = nome.isNotBlank() && pub_year.isNotBlank() && compositor.isNotBlank() && instrumentacao.isNotBlank() && genre.isNotBlank()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFADE))
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Obras Históricas",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFF44336),
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.align(
                    Alignment.CenterHorizontally
                )
            )

            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome da Obra", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = compositor,
                onValueChange = { compositor = it },
                label = { Text("Compositor", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = instrumentacao,
                onValueChange = { instrumentacao = it },
                label = { Text("Instrumentação", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )


            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = pub_year,
                onValueChange = { pub_year = it },
                label = { Text("Ano de Publicação", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = genre,
                onValueChange = { genre = it },
                label = { Text("Genêro", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (isFormValid) {
                        viewModel.addOrUpdateBook(selectedSongId, nome, pub_year.toIntOrNull() ?: 1, compositor, instrumentacao, genre)
                        nome = ""
                        pub_year = ""
                        compositor = ""
                        instrumentacao = ""
                        genre = ""
                        selectedSongId = null
                    }
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336), disabledContainerColor = Color(0xFFF44336).copy(alpha = 0.5f)),
                enabled = isFormValid
            ) {
                Text(if (selectedSongId == null) "Adicionar Obra" else "Atualizar Obra", color = Color.White)
            }

            LazyColumn (
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(songList) { tenis ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, RoundedCornerShape(8.dp))
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Nome: ${tenis.nomeObra}", color = Color.Black)
                            Text(text = "Compositor: ${tenis.compositor}", color = Color.Black)
                            Text(text = "Instrumentação: ${tenis.instrumentacao}", color = Color.Black)
                            Text(text = "Ano: ${tenis.ano}", color = Color.Black)
                            Text(text = "Genero: ${tenis.genero}", color = Color.Black)
                        }

                        Row {
                            // Botão de editar
                            IconButton(onClick = {
                                nome = tenis.nomeObra
                                pub_year = tenis.ano.toString()
                                compositor = tenis.compositor
                                instrumentacao = tenis.instrumentacao
                                genre = tenis.genero
                                selectedSongId = tenis.id
                            }) {
                                Icon(
                                    imageVector = Icons.Outlined.Edit,
                                    modifier = Modifier.size(32.dp),
                                    contentDescription = "Editar Obra",
                                    tint = Color.Unspecified
                                )
                            }
                        }
                        IconButton(onClick = { viewModel.deleteBook(tenis) }) {
                            Icon(
                                imageVector = Icons.Outlined.Delete,
                                modifier = Modifier.size(32.dp),
                                contentDescription = "Excluir Obra",
                                tint = Color.Unspecified
                            )
                        }
                    }
                }
            }
        }
    }
}
