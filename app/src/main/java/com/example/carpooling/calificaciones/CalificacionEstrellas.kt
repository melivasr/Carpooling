package com.example.carpooling.calificaciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carpooling.R
/**
 * Actividad para mostrar la interfaz de calificación con estrellas.
 */
class CalificacionEstrellas : AppCompatActivity() {
    /**
     * Método llamado cuando se crea la actividad.
     *
     * @param savedInstanceState Estado previamente guardado de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calificacion_estrellas)
    }
}