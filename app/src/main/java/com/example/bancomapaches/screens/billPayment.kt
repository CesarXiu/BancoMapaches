package com.example.bancomapaches.screens

import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bancomapaches.navigation.AppScreens
import kotlin.math.roundToInt


@Composable
fun billPayment(navController: NavController){
    Scaffold{ paddingValues ->
        bodyContentBillPayment(navController, Modifier.padding(paddingValues))//navController, Modifier.padding(paddingValues)
    }
}
@Composable
fun bodyContentBillPayment(navController:NavController, paddingValues:Modifier){
    var amountInput = remember {mutableStateOf("0")}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(59, 99, 142)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        paymentHeader()
        totalAmount(amountInput = amountInput)
        tip()
        total(total = amountInput)
        Spacer(modifier = Modifier.weight(1f))
        bottomNav(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp)
                .background(Color(35, 31, 64)), billActive = false,
            onClickHome = {
                navController.navigate(AppScreens.GreetingCard.route)
            },
            onClickCard = {
                navController.navigate(AppScreens.Menu.route)
            })
    }
}
@Composable
fun paymentHeader(){
    Box(modifier = Modifier
        .background(Color(35, 31, 64))
        .fillMaxWidth()
        .height(90.dp)){
        Text("\$ Bill Payment \$", color = Color.White, fontSize = 50.sp, modifier = Modifier.padding(15.dp))
    }
}
@Composable
fun totalAmount(modifier:Modifier = Modifier, amountInput: MutableState<String>){
    var amountInputInt by remember {mutableStateOf("")}
    Text("Total Amount", color = Color.White, fontSize = 30.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(15.dp))
    TextField(
        value = amountInputInt,
        onValueChange = {
            if (it.isEmpty() || it.matches(Regex("^\\d*\\.?\\d*\$"))) {
                amountInputInt = it
                val auxiliar = if (it.isNotEmpty()) it.toDouble() * 1.16 else 0.0
                amountInput.value = auxiliar.toString()
            }
        },
        modifier = modifier,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
    Text("16% IVA",color = Color.White, fontSize = 20.sp)
    Text("YOUR PAYING: \$${amountInput.value} USD",color = Color.White, fontSize = 20.sp)
}
@Composable
fun checked(){
    val iconChecked = Icons.Outlined.Favorite
    val colorChecked = Color.Red
    Icon(
        imageVector = iconChecked,
        contentDescription = null,
        tint = colorChecked
    )
}
@Composable
fun notChecked(){
    val iconNotChecked = Icons.Outlined.FavoriteBorder
    val colorNotChecked = Color.Gray
    Icon(
        iconNotChecked,
        contentDescription = null,
        tint = colorNotChecked
    )
}

@Composable
fun DropDownMenu() {
    var expanded by remember { mutableStateOf(false) }
    val contextForToast = LocalContext.current.applicationContext

    var porcentaje15:Boolean = true
    var porcentaje10:Boolean = false
    var porcentaje20:Boolean = false

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.TopEnd),
            contentAlignment = Alignment.Center,

        ) {
            IconButton(
                onClick = {
                    expanded = true
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(modifier = Modifier.padding(start = 5.dp,top = 5.dp,bottom = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                    Text("15%", color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(end = 5.dp))
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Open Menu",
                        modifier = Modifier
                            .size(80.dp)
                            .wrapContentSize(align = Alignment.CenterStart),
                    )
                }
                //Text("%", color = Color.White, fontSize = 40.sp)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = {
                        Text("10%")
                    },
                    onClick = {
                        //Toast.makeText(contextForToast, "¡Suscrito😎!", Toast.LENGTH_SHORT).show()
                        expanded = false
                        porcentaje10 = !porcentaje10
                    },
                    leadingIcon =  { if (porcentaje10) checked() else notChecked() }
                )

                DropdownMenuItem(
                    text = {
                        Text("15%")
                    },
                    onClick = {
                        //Toast.makeText(contextForToast, "Suscribir🙏", Toast.LENGTH_SHORT).show()
                        expanded = false
                        porcentaje15= !porcentaje15
                    },
                    leadingIcon =  { if (porcentaje15) checked() else notChecked() }
                )

                DropdownMenuItem(
                    text = {
                        Text("20%")
                    },
                    onClick = {
                        /*Toast.makeText(contextForToast, "JetpackCompose.pro", Toast.LENGTH_SHORT)
                            .show()*/
                        expanded = false
                        porcentaje20 = !porcentaje20
                    },
                    leadingIcon =  { if (porcentaje20) checked() else notChecked() }
                )
            }
        }
    }
}

@Composable
fun tipAmount(){
    var amountInput by remember {mutableStateOf("0")}
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("Tip Amount", color = Color.White, fontSize = 30.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(15.dp))
        Row(
            modifier = Modifier
                .wrapContentSize(align = Alignment.CenterEnd)
                .padding(bottom = 15.dp, start = 50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
            ) {
            Text("Select Tip Percentage", color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(end = 15.dp))
            DropDownMenu()
        }
        Row(
        modifier = Modifier.padding(start = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,){
        TextField(
            value = amountInput,
            onValueChange = {
                if (it.isEmpty() || it.matches(Regex("^\\d*\\.?\\d*\$"))) {
                    amountInput = it
                }
            },
            modifier = Modifier,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )

        }
    }
}
@Composable
fun tip(modifier: Modifier = Modifier){
    var checked by remember { mutableStateOf(true) }
    Row(modifier = Modifier.padding(top = 15.dp, bottom = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        Text("¿Te gustaria dejar propina?", color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(end = 15.dp))
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )
    }
    if(checked){
        tipAmount()
    }
}
@Composable
fun total(modifier:Modifier = Modifier, total: MutableState<String>){
    var checked by remember { mutableStateOf(true) }
    var final by remember { mutableStateOf("0") }

    LaunchedEffect(total.value) {
        final = if (checked) {
            total.value.toDouble().roundToInt().let { if (it < total.value.toDouble()) it + 1 else it }.toString()
        } else {
            total.value
        }
    }
    //final = total.value
    Row(modifier = Modifier.padding(top = 15.dp, bottom = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        Text("¿Te gustaria redondear tu pago?", color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(end = 15.dp))
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
                final = if (checked) {
                    total.value.toDouble().roundToInt().let { if (it < total.value.toDouble()) it + 1 else it }.toString()
                } else {
                    total.value
                }
            }
        )
    }
    Text("YOUR PAYING: \$$final USD",color = Color.White, fontSize = 30.sp)
}

@Preview(showSystemUi=true)
@Composable
fun myPreviewBill(){
    var amountInput = remember {mutableStateOf("0")}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(59, 99, 142)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        paymentHeader()
        totalAmount(amountInput = amountInput)
        tip()
        total(total = amountInput)
        Spacer(modifier = Modifier.weight(1f))
        bottomNav(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp)
                .background(Color(35, 31, 64)), billActive = false)
    }
}