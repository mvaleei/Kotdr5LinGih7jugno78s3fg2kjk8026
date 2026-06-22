package com.example.calcolarea

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.calcolarea.ui.theme.CalcolAreaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            //creiamo gli stati per contenere i valori digitati
            var baseFigura by remember { mutableStateOf("0") }
            var altezzaFigura by remember { mutableStateOf("0") }
            var calcolato by remember { mutableStateOf("0") }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier =Modifier
                    .background(Color(0xFFBBDEFB))
                    .fillMaxWidth()
                    .fillMaxHeight()

            ) {

                Row(

                ) {
                    TextField(
                        value=baseFigura,
                        onValueChange = {

                            baseFigura=it
                        },
                        label = {
                            Text(
                                text="Base: $baseFigura"
                            )
                        },

                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    TextField(
                        value=altezzaFigura,
                        onValueChange = {
                            altezzaFigura=it

                        },
                        label = {
                            Text(
                                text="Altezza: $altezzaFigura"
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }

                Row(

                ) {
                    Button(
                        onClick = {

                            val BaseFigura = baseFigura.toInt()
                            val AltezzaFigura = altezzaFigura.toInt()
                            calcolato = ((BaseFigura * AltezzaFigura)/2).toString()


                        }
                    ) {
                        Text(
                            text = "Calcolo area"
                        )
                    }

                    Text(
                        text = "Area: $calcolato"
                    )
                }
            }



        }
    }
}

