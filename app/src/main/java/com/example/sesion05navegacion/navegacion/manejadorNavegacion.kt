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

    NavHost(navController = navControlador, startDestination = "Principal"){
        //Definiendo rutas de navegacion
        composable(route = "Principal"){
            PrincipalUI(navControlador)
        }
        composable(route = "Registros"){
            RegistrosUI(navControlador)
        }
    }
}