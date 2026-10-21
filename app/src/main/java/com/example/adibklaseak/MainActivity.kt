package com.example.adibklaseak

import android.os.Bundle
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
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adibklaseak.models.Datuak2
import com.example.adibklaseak.models.Pertsonaia
import com.example.adibklaseak.ui.theme.AdibKlaseakTheme
import androidx.compose.foundation.lazy.items

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
    val pertsonaiak = Datuak2().pertsonaiakZerrenda()
    LazyColumn(modifier = modifier) {
        items(pertsonaiak){pertsonaia -> PertsonaiaCard(pertsonaia)}
    }
}
@Composable
fun PertsonaiaCard(pertsonaia:Pertsonaia, modifier: Modifier = Modifier) {
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
                painter = painterResource(pertsonaia.irudia),
                contentDescription = pertsonaia.name, // Dynamic content description
                modifier = Modifier.padding(10.dp)
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