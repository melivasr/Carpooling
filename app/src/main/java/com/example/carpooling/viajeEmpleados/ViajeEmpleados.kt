package com.example.carpooling.viajeEmpleados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.carpooling.R
import com.example.model.EmpleadoViaje
import com.example.retrofit.EmpleadoViajeApi
import com.example.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViajeEmpleados : AppCompatActivity() {
    /**
     * Método llamado cuando la actividad se crea.
     *
     * @param savedInstanceState Datos que pueden ser utilizados para restablecer el estado de la actividad.
     */
    val apiService = RetrofitService().getRetrofit().create(EmpleadoViajeApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carpooling)

        val correo = intent.getStringExtra("email").toString()
        val ubicacion = intent.getStringExtra("ubicacion").toString()

        val botonEmpleado = findViewById<Button>(R.id.botonEmpleado)
        botonEmpleado.setOnClickListener {
            enviarViaje(correo, ubicacion)
        }
    }
    private fun enviarViaje(correo: String, ubicacion: String) {
        val empleadoViaje = EmpleadoViaje()
        empleadoViaje.correo = correo
        empleadoViaje.ubicacion = ubicacion

        val call = apiService.save(empleadoViaje)
        call.enqueue(object : Callback<EmpleadoViaje> {
            override fun onResponse(call: Call<EmpleadoViaje>, response: Response<EmpleadoViaje>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@ViajeEmpleados, "Solicitud enviada", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@ViajeEmpleados, "Error en la solicitud", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<EmpleadoViaje>, t: Throwable) {
                Toast.makeText(this@ViajeEmpleados, "Error en la solicitud", Toast.LENGTH_SHORT).show()
            }
        })
    }

}