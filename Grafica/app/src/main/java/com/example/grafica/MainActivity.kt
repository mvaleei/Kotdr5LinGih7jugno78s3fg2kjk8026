package com.example.grafica

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.grafica.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    //dichiaro le variabile che serviranno a mappare gli oggetti della grafica (xml)
    lateinit var Numero1: EditText
    lateinit var Numero2: EditText
    lateinit var risultato: TextView

    lateinit var btSomma: Button
    lateinit var btSottrai: Button
    lateinit var btDividi: Button
    lateinit var btMoltiplica: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //collego la grafica xml alla logica del file activity
        setContentView(R.layout.activity_main)


        //assegno gli oggeti alle variabili dichiarate
        Numero1= findViewById(R.id.NumeroBase)
        Numero2= findViewById(R.id.NumeroSecondario)
        risultato=findViewById(R.id.risultato)

        btSomma= findViewById(R.id.btn_somma)
        btSottrai= findViewById(R.id.btn_sottrai)
        btDividi= findViewById(R.id.btn_dividi)
        btMoltiplica= findViewById(R.id.btn_moltiplica)

        //catturiamo gli eventi click dei pulsanti
        btSomma.setOnClickListener (this)
        btMoltiplica.setOnClickListener (this)
        btDividi.setOnClickListener (this)

        //gestione degli eventi senza importare
        //l'interfaccia
        btSottrai.setOnClickListener {
            risultato.text = (Numero1.text.toString().toInt() -Numero2.text.toString().toInt()).toString()
        }


    }



    //il metodo dell'interfaccia della view
    override fun onClick(vista: View?) {
        val Valore1 = Numero1.text.toString().toInt()
        val Valore2 = Numero2.text.toString().toInt()

        var result:Int=0
        when (vista?.id){

            R.id.btn_somma -> {
                result =Valore1+Valore2
            }

            R.id.btn_dividi -> {
                result =Valore1/Valore2
            }

            R.id.btn_moltiplica -> {
                result =Valore1*Valore2
            }

        }

        risultato.text="Risultato: $result"

        //println("Ho cliccato")
    }


}