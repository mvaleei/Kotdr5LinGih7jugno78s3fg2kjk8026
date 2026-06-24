package com.example.navgiugno

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun Profilo(modifier: Modifier= Modifier){
    Column() {
        Text(
            text = "email:email@email.it"
        )
        Text(
            text = "Cellulare:333/4445566"
        )
        Text(
            text ="User: $MainActivity.nomeutente"
        )
        Text(
            text ="Passowrd: ${MainActivity.password}"
        )
    }

}