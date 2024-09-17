package com.example.sesion05navegacion.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sesion05navegacion.componentesUI.BotonFlotante
import com.example.sesion05navegacion.componentesUI.ElementosLazy
import com.example.sesion05navegacion.componentesUI.TopBarra
import com.example.sesion05navegacion.modelos.Personas

val listaPersonas = mutableStateListOf<Personas>()

@Composable
fun PrincipalUI(navcontrolador:NavController){
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { TopBarra(titulo = "APP Registros") },
        floatingActionButton = {
            BotonFlotante{
                //navegar a Registros
                navcontrolador.navigate("Registros")
            }
        }
    ) {
        paddingX->
        Column(modifier = Modifier.padding(paddingX)) {
            Card(modifier = Modifier.fillMaxWidth().padding(5.dp)) {
                Box(modifier=Modifier.fillMaxWidth(),contentAlignment = Alignment.Center) {
                    Text(text = "Listado de Registros")
                }

            }
            LazyColumn {
                items(listaPersonas) { it->
                    ElementosLazy(personsa = it)
                }
            }
        }
    }
}