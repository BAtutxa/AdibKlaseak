package com.example.adibklaseak

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adibklaseak.models.Pertsonaia
import com.example.adibklaseak.ui.theme.AdibKlaseakTheme
import kotlinx.serialization.json.Json
import com.example.adibklaseak.models.Datuak


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            AdibKlaseakTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PertsonaiaZerrenda(modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PertsonaiaZerrenda (modifier : Modifier = Modifier){
    //val pertsonaiak = Datuak2().pertsonaiakZerrenda()
    val context = LocalContext.current
    val pertsonaiak = remember { Datuak().datuakKargatu(context, "ikasleekin.json")}
    remember { Log.d("Lista de personajes",pertsonaiak.toString())}
    LazyColumn(modifier = modifier) {
        items(pertsonaiak){pertsonaia -> PertsonaiaCard(pertsonaia)}
    }
}

@Composable
fun PertsonaiaCard(pertsonaia:Pertsonaia, modifier: Modifier = Modifier) {
    val irudia = when (pertsonaia.irudia){
        "broly" -> R.drawable.broly
        "dodoria" -> R.drawable.dodoria
        "freezer" -> R.drawable.freezer
        "ginyu" -> R.drawable.ginyu
        "jiren" -> R.drawable.jiren
        "marcarita" -> R.drawable.marcarita
        "raditz" -> R.drawable.raditz
        else -> R.drawable.zarbon
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        // ✅ 2. Internal children use fresh Modifier chains
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(

                painter = painterResource(irudia),
                contentDescription = pertsonaia.name, // Dynamic content description
                modifier = Modifier.padding(10.dp)
                    .size(100.dp)
            )
            Column(
                modifier = Modifier.padding(5.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = pertsonaia.name ,
                    fontSize = 20.sp,
                    lineHeight = 22.sp
                )
                Row {
                    Text(text = "KI: ${pertsonaia.ki}")
                    Text(text = "Max KI: ${pertsonaia.maxKi}")
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AdibKlaseakTheme {
        PertsonaiaZerrenda()
    }
}