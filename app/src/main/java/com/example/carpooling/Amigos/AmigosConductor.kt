package com.example.carpooling.Amigos

import android.os.Bundle
import com.example.carpooling.R
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class AmigosConductor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amigos)

        val usuarioSeleccionado = intent.getStringExtra("usuarioSeleccionado")

        // Utiliza el valor de usuarioSeleccionado para actualizar la interfaz de usuario según sea necesario
    }
}