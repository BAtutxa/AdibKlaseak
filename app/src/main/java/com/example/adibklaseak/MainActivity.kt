package com.example.adibklaseak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.adibklaseak.models.Pertsonaia
import com.example.adibklaseak.ui.theme.AdibKlaseakTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdibKlaseakTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PertsonaiaCard(modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PertsonaiaCard(modifier: Modifier = Modifier) {
    val pertsonaia = Pertsonaia("Ginyu", 8000 , 20000)
    Column() {
        Card (modifier = modifier.weight(1f)){
            Row(modifier = modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(R.drawable.ginyu),
                    contentDescription = null
                )
                Column() {
                    Text(
                        text = pertsonaia.name,
                        fontSize = 16.sp,
                        lineHeight = 18.sp
                        )
                    Row () {
                        Text (text = "${pertsonaia.ki}")
                        Text(text = "${pertsonaia.maxKi}")
                    }
                }
            }
        }   

        Card (modifier = modifier.weight(1f)){
            Row(modifier = modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(R.drawable.freezer),
                    contentDescription = null
                )
                Column() {
                    Text(
                        text = pertsonaia.name,
                        fontSize = 16.sp,
                        lineHeight = 18.sp
                    )
                    Row () {
                        Text (text = "${pertsonaia.ki}")
                        Text(text = "${pertsonaia.maxKi}")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AdibKlaseakTheme {
        PertsonaiaCard()
    }
}