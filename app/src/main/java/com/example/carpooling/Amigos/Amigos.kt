package com.example.carpooling.Amigos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carpooling.R
/**
 * Actividad para mostrar la información de amigos.
 */
class Amigos : AppCompatActivity() {
    /**
     * Método llamado cuando se crea la actividad.
     *
     * @param savedInstanceState Estado previamente guardado de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amigos)

        // Obtener el usuario seleccionado de los extras del Intent
        val usuarioSeleccionado = intent.getStringExtra("usuarioSeleccionado")

        // Utiliza el valor de usuarioSeleccionado para actualizar la interfaz de usuario según sea necesario
    }
}