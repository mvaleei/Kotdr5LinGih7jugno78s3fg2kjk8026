package com.example.calcolarea

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


@Composable
fun Messaggio(){


    var scelta by remember { mutableStateOf("Nulla") }

    var visibilita by remember { mutableStateOf(false) }

    Button(
        onClick = {
            visibilita=true
        }
    ) {
        Text(
            text = "Apri dialog"
        )
    }
    Text(
        text = "L'utente ha scelto: $scelta"
    )

    if (visibilita){
        AlertDialog(
            onDismissRequest = { visibilita=false },
            confirmButton = {
                TextButton(
                onClick = {
                        visibilita=false
                        scelta="Conferma"

                }
                )
                {
                    Text(
                        text = "OK"
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        visibilita=false
                        scelta="ANNULLATO"
                    }
                ) {
                    Text(
                        text = "CANCELLA"
                    )
                }
            },
            title = {
                Text(
                    text = "Titolo alert"
                )
            },
            text = {
                Text(
                    text = "Vuoi cancellare la fattura?"
                )
            }


        )
    }
}