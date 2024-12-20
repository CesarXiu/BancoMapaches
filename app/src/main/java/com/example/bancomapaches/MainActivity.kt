package com.example.bancomapaches

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bancomapaches.navigation.AppNavigation
import com.example.bancomapaches.ui.theme.BancoMapachesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun myLabel(text: String){
    Text(text,fontSize = 20.sp)
}
@Composable
fun principal(){
    Row( modifier = Modifier.background(Color.Gray).fillMaxSize()){
        Image(
            painterResource(R.drawable.ic_launcher_foreground),
            "Imagen de Ejemplo",
            modifier = Modifier.clip(CircleShape).background(Color.Green)
        )
        Column(modifier = Modifier.padding(12.dp)){
            myLabel("Jetpack Compose esta facil")
            myLabel("Jetpack Compose esta dificil")
        }
    }
}

@Preview(showSystemUi=true)
@Composable
fun myPreview(){
    principal()
}
