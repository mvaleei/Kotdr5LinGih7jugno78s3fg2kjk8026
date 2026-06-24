package com.example.navgiugno

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun Mio(modifier: Modifier= Modifier){
    Column() {
        Text(
            text = "Informazioni personali"
        )
        Text(
            text = "Accesso non autorizzato"
        )
    }

}