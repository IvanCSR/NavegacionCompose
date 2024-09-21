package com.example.sesion05navegacion.componentesUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.sesion05navegacion.modelos.Personas
import com.example.sesion05navegacion.views.listaPersonas

@Composable
fun CajaTexoGenerico(valor: String,label:String,onvalue:(String)->Unit){
    OutlinedTextField(value =valor , onValueChange = onvalue,
        label={ Text(text = label)})
}
@Composable
fun BotonGenerico(texto:String,icono:ImageVector,onclick:()->Unit){
    Button(onClick =onclick) {
        Icon(imageVector = icono, contentDescription = null)
        Text(text = texto)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarra(titulo:String, colorBarra:Color){
    TopAppBar(title = { Text(text =titulo) }, colors =TopAppBarDefaults.topAppBarColors(
            containerColor = colorBarra
        )
    )
}

@Composable
fun ElementosLazy(personsa:Personas, indice:Int){
    var verDialogo by remember { mutableStateOf(false) }
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFc0e1ff))) {
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceEvenly) {
            Column(modifier = Modifier
                .fillMaxSize()
                .weight(2.5f)) {
                Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceEvenly) {
                    Text(text =  "Nombre: ${personsa.nombres}")
                    Text(text = "Apellido: ${personsa.apellidos}")
                }
                Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = "DNI ${personsa.dni}")
                    Text(text = "FecNac: ${personsa.fecha}")
                }
            }
            Row (modifier = Modifier
                .weight(1f)
                .padding(end = 3.dp), horizontalArrangement = Arrangement.End){
               BotonGenerico(texto = "", icono = Icons.Default.Delete) {
                   verDialogo=true;
               }
            }
        }
        //dialogo
        DialogoPersonalizado(visible = verDialogo, cancelaAccion = {verDialogo=false},
            aceptaAccion = {
                //Remover una persona por el indice
                listaPersonas.removeAt(indice)
                verDialogo=false
            })
    }
    HorizontalDivider(modifier = Modifier.padding(2.dp))
}

@Composable
fun BotonFlotante(onclick:()->Unit){
    FloatingActionButton(onClick = onclick) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
    }
}
@Composable
fun DialogoPersonalizado(visible:Boolean,cancelaAccion:()->Unit,aceptaAccion:()->Unit){
    if (visible){
        AlertDialog(
            title = { Text(text = "Confirmacion de eliminacion")},
            text = { Text(text = "¿Desea Eliminar?")},
            onDismissRequest = { cancelaAccion()},
            confirmButton = {
                TextButton(onClick = { aceptaAccion() }) {
                    Text(text = "Aceptar")
                }
            }, dismissButton ={
                TextButton(onClick = { cancelaAccion() }) {
                    Text(text = "Cancelar")
                }
            }
        )
    }
}
@Composable
fun TarjetaGeneica(modifier: Modifier, colorFondo: Color){
    Card(modifier =modifier.fillMaxWidth(),colors = CardDefaults.cardColors(containerColor = colorFondo)) {

    }
}