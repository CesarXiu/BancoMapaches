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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.bancomapaches.navigation.AppScreens


@Composable
fun greetingCard(navController: NavController){
    Scaffold{ paddingValues ->
        bodyContent(navController,Modifier.padding(paddingValues))
    }
}

@Composable
fun bodyContent(navController:NavController, paddingValues:Modifier){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("FELIZ CUMPLEAÑOS")
        Button(onClick = {
            navController.navigate(AppScreens.Menu.route)
        }){
            Text("Menu")
        }
    }
}

@Preview(showSystemUi=true)
@Composable
fun myPreview(){
    //greetingCard()
}