package com.example.carpooling.calificaciones
class CalificacionPromedio {
    fun calcularPromedio(calificacion1: Double, calificacion2: Double): Double {
        return (calificacion1 + calificacion2) / 2
    }
}

fun main() {
    // Ejemplo de uso
    val calificaciones = CalificacionPromedio()
    val calificacion1 = 8.5
    val calificacion2 = 9.0
    val promedio = calificaciones.calcularPromedio(calificacion1, calificacion2)
    println("La calificación promedio es: $promedio")
}
