package com.example.notismart.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.History
import androidx.compose.ui.graphics.Color
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.items
import com.example.notismart.presentation.theme.NotiSmartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotiSmartTheme {
                NotiSmartApp()
            }
        }
    }
}

@Composable
fun NotiSmartApp() {
    var screenState by remember { mutableStateOf("inicio") }

    when (screenState) {
        "inicio" -> NotiSmartInicioScreen(onStart = { screenState = "seleccion" })
        "seleccion" -> NotiSmartSeleccionScreen(onGoToHistorial = { screenState = "historial" })
        "historial" -> NotiSmartHistorialScreen(onBack = { screenState = "seleccion" })
    }
}

@Composable
fun NotiSmartInicioScreen(onStart: () -> Unit) {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "NotiSmart",
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onBackground
                )
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = onStart,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primary,
                        contentColor = MaterialTheme.colors.onPrimary
                    )
                ) {
                    Text("Comenzar")
                }
            }
        }
    }
}
@Composable
fun NotiSmartSeleccionScreen(onGoToHistorial: () -> Unit) {
    Scaffold {
        val buttonModifier = Modifier.fillMaxWidth()
        val buttonColors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary
        )

        ScalingLazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(10.dp)
        ) {
            item {
                Button(onClick = {}, modifier = buttonModifier, colors = buttonColors) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Filled.LocalDrink, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Tomar agua")
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {}, modifier = buttonModifier, colors = buttonColors) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Filled.MenuBook, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Estudiar")
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {}, modifier = buttonModifier, colors = buttonColors) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Filled.SelfImprovement, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Pausa activa")
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = onGoToHistorial, modifier = buttonModifier, colors = buttonColors) {

                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Ver historial")
                }
            }
        }
    }
}


@Composable
fun NotiSmartHistorialScreen(onBack: () -> Unit) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Historial de recordatorios",
                fontSize = 16.sp,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text("• Tomar agua 💧", color = MaterialTheme.colors.onSurface)
            Text("• Estudiar 📚", color = MaterialTheme.colors.onSurface)
            Text("• Pausa activa 🧘", color = MaterialTheme.colors.onSurface)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onBack,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = MaterialTheme.colors.onSecondary
                )
            ) {
                Text("Volver")
            }
        }
    }
}

@Preview(device = "id:wearos_small_round")
@Preview(device = "id:wearos_large_round")
@Composable
fun PreviewNotiSmartApp() {
    NotiSmartTheme {
        NotiSmartApp()
    }
}


