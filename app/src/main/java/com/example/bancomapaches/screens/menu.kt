package com.example.bancomapaches.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.bancomapaches.navigation.AppScreens

@Composable
fun Menu(navController: NavController){
    Scaffold{ paddingValues ->
        secondbodyContent(navController,Modifier.padding(paddingValues))
    }
}

@Composable
fun secondbodyContent(navController:NavController, pading:Modifier){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Menu del Cumpleañero")
        Button(onClick = {
            navController.navigate(AppScreens.GreetingCard.route)
        }){
            Text("Tarjeta de Cumpleaños")
        }
    }
}

@Preview(showSystemUi=true)
@Composable
fun mySecondPreview(){
    //Menu()
}