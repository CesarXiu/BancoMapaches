package com.example.bancomapaches.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bancomapaches.navigation.AppScreens


@Composable
fun calculadora(navController: NavController){
    Scaffold{ paddingValues ->
        bodyContentCalculadora(navController, Modifier.padding(paddingValues))
    }
}

@Composable
fun bodyContentCalculadora(navController:NavController, paddingValues:Modifier){
    bottomNav(Modifier.fillMaxWidth().padding(bottom = 50.dp).background(Color(35, 31, 64)), onClickCard = {
        navController.navigate(AppScreens.Menu.route)
    },onClickBill = {
        navController.navigate(AppScreens.Bill.route)
    }, homeActive = false,
        onClickCalc = {
            navController.navigate(AppScreens.calculadora.route)
        })
}

@Preview(showSystemUi=true)
@Composable
fun calculadoraPreview(){
    bottomNav(Modifier.fillMaxWidth().padding(bottom = 50.dp).background(Color(35, 31, 64)), calcActive = false)
}