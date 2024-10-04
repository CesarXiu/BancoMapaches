package com.example.bancomapaches.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bancomapaches.screens.Menu
import com.example.bancomapaches.screens.greetingCard

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController=navController,startDestination=AppScreens.Menu.route){
        composable(route = AppScreens.Menu.route){
            Menu(navController)
        }
        composable(route = AppScreens.GreetingCard.route){
            greetingCard(navController)
        }
    }
}
