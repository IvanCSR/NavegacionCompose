package com.example.sesion05navegacion.views

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.sesion05navegacion.componentesUI.BotonGenerico
import com.example.sesion05navegacion.componentesUI.CajaTexoGenerico
import com.example.sesion05navegacion.componentesUI.TopBarra
import com.example.sesion05navegacion.modelos.Personas

val listaEstadoCivil= listOf("Soltero","Casado","Divorciado")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrosUI(navcontrolador: NavController){
    //Variables de estado
    var nombres by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }
    var textoSele by remember { mutableStateOf(listaEstadoCivil[0]) }
    var expandir by remember { mutableStateOf(false) }
    //obtener el contexto
    val contexto= LocalContext.current

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { TopBarra(titulo = "APP Registros", colorBarra = Color(0xFFc1f1e0)) }
    ) {paddingX->
        Column(modifier = Modifier
            .padding(paddingX)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                Text(text = "Registrar Persona")
            }
            CajaTexoGenerico(valor = nombres, label = "Nombres") {
                nombres=it
            }
            CajaTexoGenerico(valor = apellidos, label = "Apellidos") {
                apellidos=it
            }
            CajaTexoGenerico(valor = dni, label = "DNI") {
                dni=it
            }
           //MenuCombo
            ExposedDropdownMenuBox(expanded = expandir, onExpandedChange ={expandir= !expandir} ) {
                TextField(modifier = Modifier.menuAnchor(),value = textoSele, onValueChange = {textoSele=it},
                    trailingIcon ={ ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandir)},
                    readOnly = true
                )
                ExposedDropdownMenu(expanded = expandir, onDismissRequest = { expandir=false }) {
                    listaEstadoCivil.forEach { elemento->
                        DropdownMenuItem(text = { Text(text = elemento) },
                            onClick = { textoSele=elemento;expandir=false },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding)
                    }
                }
            }

            Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                BotonGenerico(texto = "Aceptar", icono = Icons.Default.Done) {
                    if (nombres.isEmpty()||apellidos.isEmpty()||dni.isEmpty()||textoSele.isEmpty()){
                        //info al usuario
                        Toast.makeText(contexto,"Faltan datos",Toast.LENGTH_SHORT).show()
                    }else{
                        //verificar la exisencia de la persona
                        var existe=listaPersonas.filter{ ele-> ele.dni.equals(dni) }.isNotEmpty()
                        if (existe){
                            Toast.makeText(contexto,"Ya existe la persona",Toast.LENGTH_SHORT).show()
                        }else{
                            listaPersonas.add(Personas(nombres,apellidos,dni,textoSele))
                            //regresar a la vista principal
                            navcontrolador.popBackStack()
                        }
                    }
                }
                BotonGenerico(texto = "Cancelar", icono = Icons.Default.Clear) {
                    //regresar a la vista principal
                    navcontrolador.popBackStack()
                }
            }
        }
    }
}