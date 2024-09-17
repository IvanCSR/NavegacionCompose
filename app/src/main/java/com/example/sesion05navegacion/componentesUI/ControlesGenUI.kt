package com.example.sesion05navegacion.componentesUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text =  "Nombre: ${personsa.nombres}")
            Text(text = "Apellido: ${personsa.apellidos}")
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){
            Text(text = "DNI ${personsa.dni}")
            Text(text = "FecNac: ${personsa.fecha}")
        }
    }
    HorizontalDivider(modifier = Modifier.padding(2.dp))
}
@Composable
fun BotonFlotante(onclick:()->Unit){
    FloatingActionButton(onClick = onclick) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
    }
}