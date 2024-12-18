package com.example.myapplication2.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdicionarScreen(onSaveClick: (String, String) -> Unit) {
    // Estado para armazenar os valores dos campos de texto
    val pessoa = remember { mutableStateOf("") }
    val descricao = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = pessoa.value,
            onValueChange = { pessoa.value = it },
            label = { Text(text = "Pessoa") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = descricao.value,
            onValueChange = { descricao.value = it },
            label = { Text(text = "Descrição") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onSaveClick(pessoa.value, descricao.value) }) {
            Text(text = "Salvar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAdicionarScreen() {
    AdicionarScreen(onSaveClick = { person, desc ->
        // Simulação de ação de salvamento
        println("Salvando pessoa: $person, descrição: $desc")
    })
}
