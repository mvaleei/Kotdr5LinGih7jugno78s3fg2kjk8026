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
import androidx.compose.ui.unit.dp
import com.example.calcolarea.ui.theme.CalcolAreaTheme
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.material3.Checkbox
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            //creiamo gli stati per contenere i valori digitati
            var baseFigura by remember { mutableStateOf("0") }
            var altezzaFigura by remember { mutableStateOf("0") }
            var calcolato by remember { mutableStateOf("0") }


            var figura by remember { mutableStateOf(true) }
            var attivazione by remember { mutableStateOf(true) }

            val listaCitta =listOf<String>("Firenze","Pescara","Como","Bari")

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier =Modifier
                    .background(Color(0xFFBBDEFB))
                    .fillMaxWidth()
                    .fillMaxHeight()

            ) {
                Row(

                ){
                    Text(
                        text = getString( R.string.app_name) + "-" +getString( R.string.sviluppatore) ,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Italic
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp) // spazio tra i campi

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
                        modifier = Modifier.weight(0.5f), // occupa metà spazio

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
                        modifier = Modifier.weight(0.5f), // occupa metà spazio
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }

                Row(

                ) {

                    Checkbox(
                        checked = figura,
                        onCheckedChange = {
                            valore -> figura=valore
                        }

                    )
                    Checkbox(
                        checked = attivazione,
                        onCheckedChange = {
                            clicca -> attivazione=clicca
                        }

                    )

                    Button(
                        onClick = {

                            val BaseFigura = baseFigura.toInt()
                            val AltezzaFigura = altezzaFigura.toInt()
                            calcolato = ((BaseFigura * AltezzaFigura)/2).toString()
                            Toast.makeText(
                                applicationContext,
                                "L'area del: ${ if (figura == true)  "Rettangolo" else "Triangolo"}  è: $calcolato",
                                Toast.LENGTH_LONG
                            ).show()


                        },
                        enabled = attivazione
                    ) {
                        Text(
                            text = "Calcolo area: ${if (figura == true) "Rettangolo" else "Triangolo"}"
                        )
                    }

                    Text(
                        text = "Area: $calcolato"
                    )
                }
                Row(

                ) {

                    /*
                    Button(
                        onClick = {

                        }
                    ) {
                        Image(
                            painter = painterResource(R.drawable.cane),
                            null
                        )
                    }

                     */

                    Compmio()
                    Citta()
                }

                Citta("Savona")
                Citta("Genova")
                listaCitta.forEach {
                    Citta(it)
                }
            }



        }
    }
}


@Composable
fun Compmio(){
    Text(
        text = "Componente INTERNO"
    )
}

