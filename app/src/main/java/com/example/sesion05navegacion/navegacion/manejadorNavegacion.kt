package com.example.sesion05navegacion.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        //definir una ruta que recibe un parametro (Tipo Int)
        composable(route = ElementoNavegacion.Registros.ruta+"/{nro}",
            arguments = listOf(navArgument(name = "nro"){type= NavType.IntType})
        ){
            RegistrosUI(navControlador,it.arguments?.getInt("nro")?:0)
        }
    }
}