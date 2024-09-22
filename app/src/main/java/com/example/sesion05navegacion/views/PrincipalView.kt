package com.example.sesion05navegacion.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sesion05navegacion.componentesUI.BotonFlotante
import com.example.sesion05navegacion.componentesUI.DialogoPersonalizado
import com.example.sesion05navegacion.componentesUI.ElementosLazy
import com.example.sesion05navegacion.componentesUI.TopBarra
import com.example.sesion05navegacion.modelos.Personas
import com.example.sesion05navegacion.navegacion.ElementoNavegacion

val listaPersonas = mutableStateListOf<Personas>()

@Composable
fun PrincipalUI(navcontrolador:NavController){
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { TopBarra(titulo = "APP Registros", Color(0xFF1ef9ce)) },
        floatingActionButton = {
            BotonFlotante{
                //navegar a Registros
                navcontrolador.navigate(ElementoNavegacion.Registros.ruta+"/${listaPersonas.size}")
            }
        }
    ) {
        paddingX->
        Column(modifier = Modifier.padding(paddingX)) {
            Card(modifier = Modifier.fillMaxWidth().padding(5.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF006b57))) {
                Box(modifier=Modifier.fillMaxWidth(),contentAlignment = Alignment.Center) {
                    Text(text = "Listado de Registros", color = Color.White)
                }
            }
            LazyColumn {
                itemsIndexed(listaPersonas) { indice,elemento->
                    ElementosLazy(personsa = elemento,indice)
                }
            }

        }
    }
}