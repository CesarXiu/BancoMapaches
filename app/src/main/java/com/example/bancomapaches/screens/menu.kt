package com.example.bancomapaches.screens

import androidx.compose.ui.graphics.Color
import android.graphics.Paint
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.bancomapaches.R
import com.example.bancomapaches.navigation.AppScreens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        Box {
            fondo(
            )
            Text("Menu del Cumpleañero")
            Button(onClick = {
                navController.navigate(AppScreens.GreetingCard.route)
            }) {
                Text("Tarjeta de Cumpleaños")
            }
        }

    }
}
@Composable
fun fondo(modifier: Modifier = Modifier) {
    val tarjeta = painterResource(R.drawable.tarjeta)
    val medialuna = painterResource(R.drawable.medialuna)
        Box(modifier) {
            Image(
                painter = tarjeta,
                contentDescription = null,
                modifier = modifier,
                contentScale = ContentScale.Crop
            )
                Image(
                    painter = medialuna,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.BottomEnd)
                        .padding(horizontal = 20.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.BottomEnd,
                    )
    }
}
@Composable
fun flores(modifier: Modifier = Modifier) {
    val flor = painterResource(R.drawable.flor)
        Image(
            painter = flor,
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
}
@Composable
fun CurvedText(text: String, radius: Float = 200f) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Canvas(
            modifier = Modifier
                .size(400.dp)
        ) {
            val textPaint = Paint().apply {
                color = 0xFFB8860B.toInt()
                textSize = 50f
                textAlign = Paint.Align.CENTER
            }

            val angleStep = (90f / text.length) * 1f  // Angulo entre cada letra

            text.forEachIndexed { index, char ->
                val angle =
                    angleStep * index + 230  // Inicia en -90° para centrar en la parte superior
                val radian = Math.toRadians(angle.toDouble())
                val x = (size.width / 2 + radius * Math.cos(radian)).toFloat()
                val y = (size.height / 2 + radius * Math.sin(radian)).toFloat()

                rotate(degrees = angle + 90, pivot = Offset(x, y)) {
                    drawContext.canvas.nativeCanvas.drawText(char.toString(), x, y, textPaint)
                }
            }
        }
    }
}

@Preview(showSystemUi=true)
@Composable
fun mySecondPreview(){
        Box {
            fondo(
                modifier = Modifier.fillMaxSize()
            )
            CurvedText("CHILI, KARAOKE, SHOTS",420f, )
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "PALOMA",
                    fontSize = 80.sp,
                    color = Color(0xFFB8860B)
                )
                Text("cumple", fontStyle = FontStyle.Italic, fontSize = 20.sp)

            }
            Column(
                modifier = Modifier.fillMaxSize().padding(bottom = 45.dp),
                horizontalAlignment = Alignment.CenterHorizontally, // Alinea horizontalmente
                verticalArrangement = Arrangement.Bottom // Alinea verticalmente
            ) {
                Text("Quiero festejar contigo mi\ncumpleaños", fontSize = 20.sp, color = Color(0xFFB8860B), textAlign = TextAlign.Center)
                Row(modifier = Modifier.fillMaxWidth().padding(start = 40.dp, end = 40.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    HorizontalDivider(
                        thickness = 1.dp, // Grosor de la línea
                        color = Color.Magenta // Color de la línea
                        , modifier = Modifier
                            .weight(1f) // Ocupa el espacio disponible en el Row
                            .padding(end = 35.dp) // Espaciado a la derecha
                    )
                    HorizontalDivider(
                        thickness = 1.dp, // Grosor de la línea
                        color = Color.Magenta // Color de la línea
                        , modifier = Modifier
                            .weight(1f) // Ocupa el espacio disponible en el Row
                            .padding(start = 30.dp) // Espaciado a la derecha
                    )
                }
                Row(modifier = Modifier.fillMaxWidth().padding(start = 40.dp, end = 40.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                    ){
                    Text("26 de octubre", color = Color.Magenta,fontSize = 20.sp)
                    flores(modifier = Modifier.width(50.dp).height(50.dp))
                    Text("9 PM - BYOB -", color = Color.Magenta, fontSize = 20.sp)
                }
                Row(modifier = Modifier.fillMaxWidth().padding(start = 40.dp, end = 40.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    HorizontalDivider(
                        thickness = 1.dp, // Grosor de la línea
                        color = Color.Magenta // Color de la línea
                        , modifier = Modifier
                            .weight(1f) // Ocupa el espacio disponible en el Row
                            .padding(end = 35.dp) // Espaciado a la derecha
                    )
                    HorizontalDivider(
                        thickness = 1.dp, // Grosor de la línea
                        color = Color.Magenta // Color de la línea
                        , modifier = Modifier
                            .weight(1f) // Ocupa el espacio disponible en el Row
                            .padding(start = 30.dp) // Espaciado a la derecha
                    )
                }
                Text("Colonia Tercera Calle 696, Villa\nChica",fontSize = 20.sp, color = Color(0xFFB8860B), textAlign = TextAlign.Center)
                Button(onClick = {
                }) {
                    Text("Confirmar asistencia")
                }
            }
    }
}