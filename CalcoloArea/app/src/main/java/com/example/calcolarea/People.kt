package com.example.calcolarea

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember

//classe per gestire i dati
data class persona (var nome : String, var anni: Int,var cognome:String)

@Composable
fun People(){

    var listaPersone = remember { mutableStateListOf(persona(anni = 50,nome="Mario", cognome = "Rossi")) }

    Text(
        text = "Componente people - Numero persone:${listaPersone.size}"
    )

    Button(
        onClick = {
            listaPersone.add(persona(nome = "Giorgio", cognome = "Verdi", anni = 12))
        }

    ) {
        Text(
            text = "Aggiungi persona"
        )
    }
    listaPersone.forEach {
        Singolo(it)
    }

}

@Composable
fun Singolo(nuovaPersona: persona){
    Text(
        text = nuovaPersona.nome + "-" + nuovaPersona.cognome + "-" +   if (nuovaPersona.anni >17) "Maggiorenne" else "Minorenne"
     )
}