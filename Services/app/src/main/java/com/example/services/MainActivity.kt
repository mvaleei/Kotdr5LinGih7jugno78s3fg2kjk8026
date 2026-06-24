package com.example.services

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.services.ui.theme.ServicesTheme
import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import io.ktor.util.InternalAPI

data class Utente (var name:String,var id:Int,var email:String, var username:String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            var Id by remember { mutableStateOf("") }
            var Nome by remember { mutableStateOf("") }
            var Email by remember { mutableStateOf("") }
            var UserName by remember { mutableStateOf("") }


            //il cast del dato tornato dall'API in
            //dati applicazione

            fun castUtente(utenteRicevuto:String){
                val gson = Gson()

                val oggettoConvertito: Utente =gson.fromJson(utenteRicevuto, Utente::class.java)

                /*
                println(oggettoConvertito.name)
                println(oggettoConvertito.username)
                println(oggettoConvertito.email)
                println(oggettoConvertito.id)

                 */

                Nome =oggettoConvertito.name
                UserName = oggettoConvertito.username
                Email= oggettoConvertito.email
                Id=oggettoConvertito.id.toString()




            }


            //funzione per gestire le chiamate API
            suspend  fun interrogaServer(){
                //println("Sto per chiamare servizio API")

                //creare il client
                var client = HttpClient()

                //ottengo la risposta dal servizio
                var risposta = client.get("https://jsonplaceholder.typicode.com/users/1")

                //println(risposta)
                castUtente(risposta.body<String>())

            }


            @OptIn(InternalAPI::class)
            suspend fun inviaAlServer() {

                val nuovoUtente: Utente = Utente(id=999, name = "Marcello", username = "Valeri", email = "v@v.it")

                val gson =Gson()

                val UtenteDaInviare =gson.toJson(nuovoUtente)

                var client = HttpClient()

                var risposta = client.post("https://jsonplaceholder.typicode.com/users")
                {
                    contentType(ContentType.Application.Json)
                    body=UtenteDaInviare
                }

                castUtente(risposta.body<String>())



            }


            ServicesTheme {
                Column(
                    modifier = Modifier
                        .background(Color(0xFFBBDEFB))
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Text(
                        text = "Componente per chiamate API"
                    )

                    Button(
                        onClick = {
                            try {
                                //coroutines
                                runBlocking {
                                    launch {
                                        interrogaServer()
                                    }
                                }

                            }
                            catch (e: Exception){
                                println(e.message.toString())
                            }

                        }
                    ) {

                        Text(text = "Chiamata GET")
                    }

                    Text(
                        text = "$Id - $Nome - $UserName - $Email"
                    )

                    Button(
                        onClick = {

                            try {
                                //coroutines
                                runBlocking {
                                    launch {
                                        //interrogaServer()
                                        inviaAlServer()
                                    }
                                }

                            }
                            catch (e: Exception){
                                println(e.message.toString())
                            }

                        }
                    ) {
                        Text(
                            text = "Chiamata POST"
                        )
                    }






                }
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
    ServicesTheme {
        Greeting("Android")
    }
}