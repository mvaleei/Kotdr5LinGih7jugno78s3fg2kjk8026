package com.example.navgiugno

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun Home(modifier: Modifier= Modifier){
    Column() {
        Text(
            text = "Sno la home dell'applicazione"
        )
        Text(
            text = "Benvenuti nella nostra applicazione aziendale"
        )
    }

}