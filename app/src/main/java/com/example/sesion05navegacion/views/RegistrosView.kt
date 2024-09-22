package com.example.sesion05navegacion.views

import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sesion05navegacion.componentesUI.BotonGenerico
import com.example.sesion05navegacion.componentesUI.CajaTexoGenerico
import com.example.sesion05navegacion.componentesUI.ComboBoxGenerico
import com.example.sesion05navegacion.componentesUI.TopBarra
import com.example.sesion05navegacion.modelos.Personas

val listaEstadoCivil= listOf("Soltero","Casado","Divorciado")


@Composable
fun RegistrosUI(navcontrolador: NavController,nro:Int){
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
            Box (modifier = Modifier.fillMaxWidth().padding(10.dp).background(Color(0xFFaac7ff)), contentAlignment = Alignment.Center){
                Text(text = "Registrar Persona Nro: ${nro.toString()} ", fontSize = 20.sp)
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
            ComboBoxGenerico(
                lista = listaEstadoCivil,
                textoSele = textoSele,
                expansion = expandir,
                onvalue = {textoSele=it},
                onExpanded = {expandir=true},
                onDismiss = { expandir=false }) {
                textoSele=it;expandir=false
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