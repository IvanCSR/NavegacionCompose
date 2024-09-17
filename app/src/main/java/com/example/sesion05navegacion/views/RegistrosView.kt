package com.example.sesion05navegacion.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RegistrosUI(navcontrolador: NavController){
    Column(modifier = Modifier.padding(top=40.dp)) {
        Text(text = "Pantalla dos")
    }
}