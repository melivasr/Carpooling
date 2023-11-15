package com.example.carpooling.mi_perfil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.carpooling.MainActivity
import com.example.carpooling.R

class Mi_perfil_empleado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_perfil_empleado)

        // Configurar el botón para cerrar sesión
        val btnCerrarSesion: Button = findViewById(R.id.buttonCerrarSesion)
        btnCerrarSesion.setOnClickListener {
            // Iniciar la actividad de inicio de sesión al hacer clic en el botón
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Cerrar la actividad actual después de iniciar sesión
        }

        val textViewNombre = findViewById<TextView>(R.id.textViewNombre)
        val textViewCorreo = findViewById<TextView>(R.id.textViewCorreo)
        val textViewCalificacion = findViewById<TextView>(R.id.textViewCalificacion)

        val nombre = intent.getStringExtra("nombre")
        val correo = intent.getStringExtra("email")
        val calificacion = intent.getStringExtra("calificacion")

        textViewNombre.text = "Nombre: $nombre"
        textViewCorreo.text = "Correo: $correo"
        textViewCalificacion.text = "Calificación: $calificacion"
    }
}