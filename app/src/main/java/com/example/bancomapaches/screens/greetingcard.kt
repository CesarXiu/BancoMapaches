package com.example.bancomapaches.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bancomapaches.R
import com.example.bancomapaches.navigation.AppScreens
import kotlin.jvm.internal.AdaptedFunctionReference


@Composable
fun greetingCard(navController: NavController){
    Scaffold{ paddingValues ->
        bodyContent(navController,Modifier.padding(paddingValues))
    }
}

@Composable
fun bodyContent(navController:NavController, paddingValues:Modifier){
    Column(
        modifier = Modifier.fillMaxSize().background(Color(26, 26, 26)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        printPP(Modifier.padding(20.dp).clip(shape = CircleShape).height(200.dp).width(200.dp).align(Alignment.CenterHorizontally))
        mainInfo()
        socials(modifier = Modifier.padding( end = 30.dp).width(30.dp).height(30.dp).clip(shape = CircleShape))
        contact(modifier = Modifier.padding( end = 5.dp).width(30.dp).height(30.dp).clip(shape = CircleShape))
        Spacer(modifier = Modifier.weight(1f))
        bottomNav(Modifier.fillMaxWidth().padding(bottom = 50.dp).background(Color(35, 31, 64)), onClickCard = {
            navController.navigate(AppScreens.Menu.route)
        },onClickBill = {
            navController.navigate(AppScreens.Bill.route)
        }, homeActive = false)
    }
}

@Composable
fun printPP(modifier: Modifier = Modifier){
    val profile_pic = painterResource(R.drawable.profile_pic)
    Image(
        painter = profile_pic,
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}
@Composable
fun printResource(painter: Painter, modifier: Modifier = Modifier){
    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}
@Composable
fun mainInfo(modifier: Modifier = Modifier){
    Column(modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("CESAR XIU", color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(10.dp))
        Text("Estudiante de Ingenieria en Sistemas Computacionales", color = Color.White, fontSize = 15.sp, modifier = Modifier.padding(bottom = 10.dp, start = 10.dp))
        Text("Estudiante de Ingeniería con un enfoque sólido en tecnologías backend, apasionado por el diseño y la implementación de soluciones robustas y escalables. Con experiencia en el desarrollo de aplicaciones web.", color = Color.White, textAlign = TextAlign.Justify, modifier = Modifier.padding(10.dp))
    }
}
@Composable
fun socials(modifier:Modifier = Modifier){
    val github = painterResource(R.drawable.github)
    val linkedin = painterResource(R.drawable.linkedin)
    val tiktok = painterResource(R.drawable.tiktok)
    val youtube = painterResource(R.drawable.youtube)
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        printResource(github, modifier = modifier)
        printResource(linkedin, modifier = modifier)
        printResource(tiktok, modifier = modifier)
        printResource(youtube, modifier = modifier)
    }
}
@Composable
fun contact(modifier:Modifier = Modifier){
    val email = painterResource(R.drawable.email)
    val share = painterResource(R.drawable.share)
    Row(modifier = Modifier.padding(10.dp)){
        Button(onClick = {

        },
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent, // Fondo transparente
                contentColor = Color.White // Color del texto y borde (amarillo oscuro)
            ),
            border = BorderStroke(1.dp, Color(96,167,255,255)), // Borde del botón
        ) {
            printResource(email, modifier = modifier)
            Text("Email")
        }
        Button(onClick = {

        },
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent, // Fondo transparente
                contentColor = Color.White // Color del texto y borde (amarillo oscuro)
            ),
            border = BorderStroke(1.dp, Color(96,167,255,255)), // Borde del botón
            ) {
            printResource(share, modifier = modifier)
            Text("Share")
        }
    }
}
@Composable
fun pill(text:String, modifier: Modifier = Modifier, onClick: (() -> Unit)? = null, colorx: Color = Color(96,167,255,255)){
    Surface(
        modifier = Modifier
            .clickable { onClick?.invoke() } // Acción al hacer clic
            .size(width = 100.dp, height = 40.dp) // Tamaño de la pastilla
            .padding(5.dp) // Espaciado interno
            .clip(RoundedCornerShape(20.dp))
        , // Bordes redondeados para hacer la forma de pastilla
        color = colorx,
    ) {
        Box(
            contentAlignment = Alignment.Center, // Centra el contenido dentro del Surface
            modifier = Modifier
                .background(Color.Transparent)
                .size(width = 120.dp, height = 40.dp)
        ) {
            Text(
                text = text, // Texto en el centro
                fontSize = 16.sp,
                color = Color.White // Color del texto
            )
        }
    }
}


@Composable
fun bottomNav(modifier: Modifier = Modifier,
              onClickCard: (() -> Unit)? = null,
              onClickBill: (() -> Unit)? = null,
              onClickHome: (() -> Unit)? = null,
              cardActive: Boolean = true,
              homeActive: Boolean = true,
              billActive: Boolean = true,){
    Row(modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        ){
        //colorx = Color(88, 121, 161)
        pill("CARD", onClick = onClickCard, colorx = (if(!cardActive) Color(88, 121, 161) else Color(96,167,255,255)))
        pill("HOME", onClick = onClickHome, colorx = (if(!homeActive) Color(88, 121, 161) else Color(96,167,255,255)))
        pill("BILL", onClick = onClickBill, colorx = (if(!billActive) Color(88, 121, 161) else Color(96,167,255,255)))
    }
}

@Preview(showSystemUi=true)
@Composable
fun myPreview(){
    Column(
        modifier = Modifier.fillMaxSize().background(Color(26, 26, 26)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        printPP(Modifier.padding(20.dp).clip(shape = CircleShape).height(200.dp).width(200.dp).align(Alignment.CenterHorizontally))
        mainInfo()
        socials(modifier = Modifier.padding( end = 30.dp).width(30.dp).height(30.dp).clip(shape = CircleShape))
        contact(modifier = Modifier.padding( end = 5.dp).width(30.dp).height(30.dp).clip(shape = CircleShape))
        Spacer(modifier = Modifier.weight(1f))
        bottomNav(Modifier.fillMaxWidth().padding(bottom = 50.dp).background(Color(35, 31, 64)), homeActive = false)
    }
}