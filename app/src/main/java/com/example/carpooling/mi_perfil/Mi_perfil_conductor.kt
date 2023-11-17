package com.example.carpooling.mi_perfil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.carpooling.MainActivity
import com.example.carpooling.R

/**
 * La clase [Mi_Perfil_Conductor] representa la actividad del perfil del conductor.
 * Permite al conductor cerrar sesión al hacer clic en el botón correspondiente.
 */
class Mi_perfil_conductor : AppCompatActivity() {
    /**
     * Método llamado cuando la actividad se crea.
     *
     * @param savedInstanceState Datos que pueden ser utilizados para restablecer el estado de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_perfil_conductor)

        // Configurar el botón para cerrar sesión
        val btnCerrarSesion: Button = findViewById(R.id.buttonCerrarSesion)
        btnCerrarSesion.setOnClickListener {
            // Iniciar la actividad de inicio de sesión al hacer clic en el botón
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Cerrar la actividad actual después de iniciar sesión
        }

        // Obtener datos del intent
        val correo = intent.getStringExtra("email")
        val nombre = intent.getStringExtra("nombre")
        val calificacion = intent.getStringExtra("calificacion")

        // Obtener referencias a los elementos de la interfaz de usuario
        val textViewNombre = findViewById<TextView>(R.id.textViewNombre)
        val textViewCorreo = findViewById<TextView>(R.id.textViewCorreo)
        val textViewCalificacion = findViewById<TextView>(R.id.textViewCalificacion)

        // Establecer los datos en los elementos de la interfaz de usuario
        textViewNombre.text = "Nombre: $nombre"
        textViewCorreo.text = "Carné: $correo"
        textViewCalificacion.text = "Calificación: $calificacion"
    }
}