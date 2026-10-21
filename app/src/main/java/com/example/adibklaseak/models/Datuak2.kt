package com.example.adibklaseak.models

import com.example.adibklaseak.R

class Datuak2 {
    fun pertsonaiakZerrenda ():List<Pertsonaia>{
        return listOf(Pertsonaia("Freezer",30,300,R.drawable.freezer),
            Pertsonaia("Ginyu", 25,250,R.drawable.ginyu),
            Pertsonaia("Dodoria",20,200,R.drawable.dodoria),
            Pertsonaia("Zarbon", 15,150,R.drawable.zarbon))
    }
}