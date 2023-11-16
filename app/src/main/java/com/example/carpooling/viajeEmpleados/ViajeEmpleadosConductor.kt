package com.example.carpooling.viajeEmpleados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.carpooling.R
import com.example.carpooling.mi_perfil.Mi_perfil_conductor
import com.example.carpooling.vista_principal_conductor
import com.example.model.EmpleadoViaje
import com.example.retrofit.EmpleadoViajeApi
import com.example.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViajeEmpleadosConductor : AppCompatActivity() {

    private lateinit var apiService: EmpleadoViajeApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carpooling_conductor)

        // Inicializa la instancia de EmpleadoViajeApi
        apiService = RetrofitService().getRetrofit().create(EmpleadoViajeApi::class.java)

        // Configura el OnClickListener para el botón botonEmpleado
        val botonEmpleado = findViewById<Button>(R.id.botonEmpleado)
        botonEmpleado.setOnClickListener {
            obtenerViajes()
        }
    }

    private fun obtenerViajes() {
        val call = apiService.getEmpleados()
        call.enqueue(object : Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if (response.isSuccessful) {
                    val viajes = response.body()
                    val ubicacion = intent.getStringExtra("ubicacion")
                    val mutableViajes = viajes?.toMutableList()

                    // Agregar "1" al inicio de la lista
                    mutableViajes?.add(0, ubicacion.toString())

                    // Agregar "33" al final de la lista
                    mutableViajes?.add("33")
                    

                    Toast.makeText(this@ViajeEmpleadosConductor, "Solicitud enviada", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@ViajeEmpleadosConductor, "Error en la solicitud", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                Toast.makeText(this@ViajeEmpleadosConductor, "Error en la solicitud", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
