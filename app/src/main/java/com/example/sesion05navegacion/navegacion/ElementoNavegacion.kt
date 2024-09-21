package com.example.sesion05navegacion.navegacion

//Objetos para identificar la navegacion
sealed class ElementoNavegacion(val ruta:String) {
    object Principal: ElementoNavegacion(RutasNav.Principal.name)
    object Registros: ElementoNavegacion(RutasNav.Registros.name)
}