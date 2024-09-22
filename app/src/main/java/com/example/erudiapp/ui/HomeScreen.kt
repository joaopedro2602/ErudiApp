package com.example.erudiapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.erudiapp.R

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFAFADE))
            .padding(42.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_classic),
                contentDescription = "Ícone Instrumento",
                tint = Color.Unspecified,
                modifier = Modifier.size(155.dp)
            )
            Text(
                text = "Bem-vindo ao ErudiApp!",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(
                onClick = { navController.navigate("songScreen") },
                modifier = Modifier.height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)) // Define a cor do botão
            ) {
                Text(
                    text = "Cadastrar Obras",
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize // Aumenta o tamanho do texto
                )
            }
        }
    }
}
