package com.example.componenti

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.componenti.ui.theme.ComponentiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val citta ="Pordenone"

            Column (            //parentesi tonde //caratteristiche del compoenten

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier =Modifier
                .background(Color(0xFFBBDEFB))

            ){   //lista dei componenti
                Text(
                    text = "Primo testo"
                )

                Text(
                    text = "Città: $citta"
                )

                Text(
                    text = "Terzo testo"
                )

                Button(
                    onClick = {
                        println("Ho cliccato")
                    }
                ) {
                    Text(
                        text = "CLiccami"
                    )
                }

                TextField(
                    value="",
                    onValueChange = {
                        println(it)
                    },
                    placeholder =
                        {
                            Text(
                                text = "Scrivi"
                            )
                        },
                    label = {
                        Text(
                            text = "Digitare"
                        )
                    }
                )

            }



        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComponentiTheme {
        Greeting("Android")
    }
}