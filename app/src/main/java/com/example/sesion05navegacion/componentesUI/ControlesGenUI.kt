package com.example.sesion05navegacion.componentesUI

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sesion05navegacion.modelos.Personas

@Composable
fun CajaTexoGenerico(valor: String,label:String,onvalue:(String)->Unit){
    OutlinedTextField(value =valor , onValueChange = onvalue,
        label={ Text(text = label)})
}
@Composable
fun BotonGenerico(texto:String,onclick:()->Unit){
    Button(onClick =onclick) {
        Text(text = texto)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarra(titulo:String){
    TopAppBar(title = { Text(text =titulo) })
}

@Composable
fun ElementosLazy(personsa:Personas){
    Card(modifier = Modifier.fillMaxWidth()) {
        Row {
            Text(text = personsa.nombres)
            Text(text = personsa.apellidos)
        }
    }
    HorizontalDivider()
}
