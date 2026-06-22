package com.example.structure

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import kotlin.reflect.typeOf



@Composable
fun Mainmio(){


    //println("Sono un testo della riga di comando")

    val citta : String="Verona"

    println(citta)

    var nazione="Italia"

    nazione="Spagna"

    println(nazione)

    //if
    if (nazione.length >5){
        println("Nome lungo")
    }
    else
    {
        println("nazioneCon nome corso")
    }

    //operatore ternario
    var anni:Int =60

    println("Sei: ${ if (anni >17)  "Maggiorenne" else "Minorenne"  }   ")

    //when
    var regione:String="Lazio"

    when (regione){
        "Lazio" -> println("Vivi a Roma")
        "Liguria" -> println("VIvi a Genova")
    }

    anni=16
    var tipologia = when{
        anni<12 -> "Baby"
        anni >=13 && anni<18 -> "Teen ager"

        else -> "Non identificato"
    }
    println(tipologia)

    when (regione){
        "Lazio","abruzzo","molise" -> println("Centro")
        "liguria","veneto"->  println("Nord")
        "sicilia","Campania" -> println("Sud")
    }


    when (anni){
        in 1..12 -> println("Sei baby")
        in 13..18 -> println("Sei teen ager")
        in 19..35 -> println("Sei adulto")
        else -> println("Non identificabile")
    }

    //ciclo for
    val ciclo:Int =15
    for ( indice in 5..ciclo  ){
        println("Sei al ciclo n.: $indice")
    }

    //array
    var listato = arrayOf("Pippo","Minni")


    listato.forEach {
        println ("Il nome è: $it")   //it che fa riferimento al valore della posizione
    }

    for (dato in listato){
        println(dato)
    }

    listato += "Clarabella"

    println("Dimensione dell'array: ${listato.size}")


    println(listato)


    println(listato[2])

    //assegnare un valore ad una posizione
    listato.set(0,"Gamba di Legno")

    leggiArray(listato)

    Text(
        text = "Sono il componente per la teoria di kotlin"
    )
}


fun leggiArray(lista: Array<String>){
    println("Sono dentro la funzione")
    lista.forEach {
        println(it)
    }
}