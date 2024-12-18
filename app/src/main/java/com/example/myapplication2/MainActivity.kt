package com.example.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication2.ui.theme.CadastroScreen
import com.example.myapplication2.ui.theme.InicioScreen
import com.example.myapplication2.ui.theme.ListScreen
import com.example.myapplication2.ui.theme.LoginScreen
import com.example.myapplication2.ui.theme.MyApplication2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication2Theme {
                AppNavigator()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {
        composable("inicio") {
            InicioScreen(onEnterClick = { navController.navigate("login") })
        }
        composable("login") {
            LoginScreen(
                onContinueClick = { navController.navigate("list") },
                onRegisterClick = { navController.navigate("cadastro") }
            )
        }
        composable("cadastro") {
            CadastroScreen(onConcludeClick = { navController.navigate("login") })
        }
        composable("list") {
            ListScreen(
                onAddClick = { navController.navigate("adicionar") },
                onSearchClick = { navController.navigate("pesquisa") }
            )
        }
        composable("adicionar") {
            AdicionarScreen(onSaveClick = { navController.navigate("list") })
        }
        composable("pesquisa") {
            PesquisaScreen(onSearchClick = { navController.navigate("resultado") })
        }
        composable("resultado") {
            ResultadoScreen()
        }
    }
}

@Composable
fun ResultadoScreen() {
    // Exemplo simples de tela de Resultado
    Text(text = "Tela de Resultado", modifier = Modifier.fillMaxSize())
}

// Exemplo básico de implementação da AdicionarScreen
@Composable
fun AdicionarScreen(onSaveClick: () -> Unit) {
    // Adiciona um botão de salvar que leva à tela de List
    Text(text = "Tela de Adicionar", modifier = Modifier.fillMaxSize())
    // Aqui você pode adicionar os campos e botões necessários para a tela de adicionar
    Button(onClick = { onSaveClick() }) {
        Text(text = "Salvar")
    }
}

// Exemplo básico de implementação da PesquisaScreen
@Composable
fun PesquisaScreen(onSearchClick: () -> Unit) {
    Text(text = "Tela de Pesquisa", modifier = Modifier.fillMaxSize())
    // Aqui você pode adicionar os campos e botões necessários para a tela de pesquisa
    Button(onClick = { onSearchClick() }) {
        Text(text = "Buscar")
    }
}
