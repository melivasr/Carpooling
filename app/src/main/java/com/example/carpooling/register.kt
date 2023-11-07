package com.example.carpooling

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class register : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val buttonregister= findViewById<Button>(R.id.buttonRegister)

        buttonregister.setOnClickListener {
            // Abrir la actividad VentanaPrincipal
            val intent = Intent(this, vista_principal::class.java)
            startActivity(intent)
        }
    }
}
