package com.example.calcolarea

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import android.widget.Button
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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize


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

                    //Compmio()
                    //Citta()
                }

                /*
                Citta("Savona")
                Citta("Genova")
                listaCitta.forEach {
                    Citta(it)
                }

                 */

                DropDownList()
            }



        }
    }
}


@Composable
fun DropDownList(){


    //dichiariamo gli stati da gestire

    //la fvisualizzazione della lista
    var collassato by remember {mutableStateOf((false))}

    //una lista di sports da visualizzare nel dropdownlist
    //può essere modificata
    val sports =  remember { mutableListOf("Nuoto" ," Rugby" ," Tennis") }


    //oggetto per contenere lo sport selezionato
    var sportSelezionato by remember {mutableStateOf((""))}


    //oggetto stato per gestire il dimensionamento
    //dell'oggetto dropdownlist
    var larghezzaOggetto by remember { mutableStateOf(Size.Zero) }


    //oggetto per gestire l'icona della lista



    Column(
        Modifier.padding(20.dp)
    ) {
        //creiamo l'oggetto che servirà ad aprire la lista
        OutlinedTextField(
            value =sportSelezionato,
            onValueChange = {sportSelezionato =it},
            label ={
                Text(
                    text = "Seleziona uno sport"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned{
                    coordinate -> larghezzaOggetto =coordinate.size.toSize()
                },
            trailingIcon = {
                Button(
                    onClick = {
                        collassato=!collassato
                    }
                ) {
                    Text(
                        text = "Apri"
                    )
                }


                /*
                Icon(
                    null,
                    "destription",
                    Modifier.clickable{collassato=!collassato}
                    )

                 */
            }

        )


        //creiamo il VERO oggetto per la grafica della lista
        DropdownMenu(
            expanded =  collassato,
            onDismissRequest = {collassato = false},
            modifier = Modifier
                .width(with(LocalDensity.current){larghezzaOggetto.width.toDp()})
        ) {
            sports.forEach {
                sportLetto ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = sportLetto
                        )
                    },
                    onClick = {
                        collassato=false
                        sportSelezionato =sportLetto
                        sports.add("Pallavolo")
                        sports.add("Pallamano")

                    }
                )
            }


        }
    }


    Text(
        text = "Numero di sport presenti: ${sports.size}"
    )

    Text(
        text = "Sport preferito: $sportSelezionato"
    )
}




@Composable
fun Compmio(){
    Text(
        text = "Componente INTERNO"
    )
}

