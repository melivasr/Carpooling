package com.example.carpooling.viajeEmpleados

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.carpooling.R

class ViajeEmpleados : AppCompatActivity() {
    /**
     * Método llamado cuando la actividad se crea.
     *
     * @param savedInstanceState Datos que pueden ser utilizados para restablecer el estado de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empleados)
    }
}