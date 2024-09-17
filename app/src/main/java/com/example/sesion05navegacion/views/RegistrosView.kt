package com.example.sesion05navegacion.views

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sesion05navegacion.componentesUI.BotonFlotante
import com.example.sesion05navegacion.componentesUI.BotonGenerico
import com.example.sesion05navegacion.componentesUI.CajaTexoGenerico
import com.example.sesion05navegacion.componentesUI.ElementosLazy
import com.example.sesion05navegacion.componentesUI.TopBarra
import com.example.sesion05navegacion.modelos.Personas

@Composable
fun RegistrosUI(navcontrolador: NavController){
    //Variables de estado
    var nombres by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    //obtener el contexto
    val contexto= LocalContext.current

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { TopBarra(titulo = "APP Registros") }
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
            CajaTexoGenerico(valor = fecha, label = "Fecha") {
                fecha=it
            }
            Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                BotonGenerico(texto = "Aceptar") {
                    if (nombres.isEmpty()||apellidos.isEmpty()||dni.isEmpty()||fecha.isEmpty()){
                        //info al usuario
                        Toast.makeText(contexto,"Faltan datos",Toast.LENGTH_SHORT).show()
                    }else{
                        listaPersonas.add(Personas(nombres,apellidos,dni,fecha))
                        //regresar a la vista principal
                        navcontrolador.popBackStack()
                    }
                }
                BotonGenerico(texto = "Cancelar") {
                    //regresar a la vista principal
                    navcontrolador.popBackStack()
                }
            }
        }
    }
}