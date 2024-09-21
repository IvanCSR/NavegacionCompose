package com.example.sesion05navegacion.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sesion05navegacion.views.PrincipalUI
import com.example.sesion05navegacion.views.RegistrosUI

@Composable
fun ManejadorNavegacion(){

    val navControlador= rememberNavController()

    NavHost(navController = navControlador, startDestination = ElementoNavegacion.Principal.ruta){
        //Definiendo rutas de navegacion
        composable(route = ElementoNavegacion.Principal.ruta){
            PrincipalUI(navControlador)
        }
        composable(route = ElementoNavegacion.Registros.ruta){
            RegistrosUI(navControlador)
        }
    }
}