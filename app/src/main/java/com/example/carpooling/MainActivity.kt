package com.example.carpooling

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/* se crea un boton para entrar  al apartado  Log in  , esto para poder iniciar secion en caso
* de que haya una cuanta registrada en la app */
        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            val intent : Intent = Intent(this , log_in::class.java)
            startActivity(intent)
        }
        val btn2: Button = findViewById(R.id.button2)
        btn2.setOnClickListener {
            val intent : Intent = Intent(this , register::class.java)
            startActivity(intent)

    }
}}