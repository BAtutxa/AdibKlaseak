package com.example.adibklaseak.models

import android.content.Context
import android.util.Log
import kotlinx.serialization.json.Json

class Datuak {
    /*fun pertsonaiakZerrenda ():List<Pertsonaia>{
        return listOf(Pertsonaia("Freezer",30,300,R.drawable.freezer),
            Pertsonaia("Ginyu", 25,250,R.drawable.ginyu),
            Pertsonaia("Dodoria",20,200,R.drawable.dodoria),
            Pertsonaia("Zarbon", 15,150,R.drawable.zarbon))
    }*/

/*    fun loadJson(context:Context, fileName: String): String {
        // Ahora usamos 'context.assets'
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }*/
fun datuakKargatu(context:Context, fitx: String): List<Pertsonaia> {
    return try {
        val jsonString = context.assets.open(fitx)
            .bufferedReader()
            .use { it.readText() }

        Log.d ("EL string: ",jsonString)

        Json { ignoreUnknownKeys = true }
            .decodeFromString<List<Pertsonaia>>(jsonString)
    } catch (e: Exception) {
        e.printStackTrace()
        emptyList()
    }
}
}