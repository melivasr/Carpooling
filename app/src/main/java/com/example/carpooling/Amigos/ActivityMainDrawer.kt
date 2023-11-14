/**package com.example.carpooling.Amigos

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.carpooling.R
import com.google.android.material.navigation.NavigationView
class ActivityMainDrawer : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amigos)

        // ... Tu código existente ...

        val navigationView = findViewById<NavigationView>(R.id.nav_item_one)  // Asegúrate de que el ID sea correcto
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_item_one -> {
                    // Manejar clic en "Amigos"
                    abrirVentanaAmigos()
                    true
                }
                R.id.nav_item_two -> {
                    // Manejar clic en "Historial de viajes"
                    abrirVentanaHistorialViajes()
                    true
                }
                R.id.nav_item_three -> {
                    // Manejar clic en "Calificaciones"
                    abrirVentanaCalificaciones()
                    true
                }
                // Manejar otros elementos del menú si es necesario
                else -> false
            }
        }
    }

    private fun abrirVentanaAmigos() {
        // Crear un Intent para abrir la actividad de Amigos
        val intent = Intent(this, Amigos::class.java)
        startActivity(intent)
    }

    private fun abrirVentanaHistorialViajes() {
        // Implementar la lógica para abrir la actividad de Historial de viajes
        // ...
    }

    private fun abrirVentanaCalificaciones() {
        // Implementar la lógica para abrir la actividad de Calificaciones
        // ...
    }
}
*/