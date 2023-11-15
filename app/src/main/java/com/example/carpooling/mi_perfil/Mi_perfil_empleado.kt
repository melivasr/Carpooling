package com.example.carpooling.mi_perfil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.carpooling.R

class Mi_perfil_empleado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_perfil_empleado)

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