package com.example.carpooling.mi_perfil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.carpooling.R


class Mi_perfil_conductor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_perfil_conductor)

        val correo = intent.getStringExtra("email")
        val nombre = intent.getStringExtra("nombre")
        val calificacion = intent.getStringExtra("calificacion")

        val textViewNombre = findViewById<TextView>(R.id.textViewNombre)
        val textViewCorreo = findViewById<TextView>(R.id.textViewCorreo)
        val textViewCalificacion = findViewById<TextView>(R.id.textViewCalificacion)

        textViewNombre.text = "Nombre: $nombre"
        textViewCorreo.text = "Correo: $correo"
        textViewCalificacion.text = "Calificación: $calificacion"
    }

}