package com.example.calcolarea

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable






@Composable
fun Citta (nomeCitta: String = "Parma"){
    println("Sono nel componente città")
    Text(
        text = "Componente ESTERNO"
    )
    Text(
        text = "Città ricevuta: $nomeCitta"
    )
}