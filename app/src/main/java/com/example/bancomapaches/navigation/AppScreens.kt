package com.example.bancomapaches.navigation

sealed class AppScreens(val route:String){
    object GreetingCard: AppScreens("greetingcard")
    object Menu: AppScreens("menu")
    object Bill: AppScreens("bill")
    object calculadora: AppScreens("calculadora")
}