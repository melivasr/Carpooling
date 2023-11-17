package com.example.carpooling.viajeAmigos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.carpooling.R
import com.example.model.RutaData
import com.example.retrofit.AmigoViajeApi
import com.example.retrofit.RetrofitService
import com.example.retrofit.RutaApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViajeAmigosConductor : AppCompatActivity() {

    private lateinit var apiService: AmigoViajeApi
    private lateinit var apiService2: RutaApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carpooling_conductor)

        // Inicializa la instancia de EmpleadoViajeApi
        apiService = RetrofitService().getRetrofit().create(AmigoViajeApi::class.java)
        apiService2 = RetrofitService().getRetrofit().create(RutaApi::class.java)

        // Configura el OnClickListener para el botón botonEmpleado
        val botonEmpleado = findViewById<Button>(R.id.botonEmpleado)
        botonEmpleado.setOnClickListener {
            obtenerViajes()
        }
    }

    private fun obtenerViajes() {
        val call = apiService.getAmigos()
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

                    val ruta = mutableViajes?.toList()
                    val rutaData = RutaData(ruta.toString())

                    Toast.makeText(this@ViajeAmigosConductor, "Solicitud enviada", Toast.LENGTH_SHORT).show()

                    val call2 = apiService2.save(rutaData)
                    call2.enqueue(object : Callback<RutaData> {
                        override fun onResponse(
                            call: Call<RutaData>,
                            response: Response<RutaData>
                        ) {
                            if (response.isSuccessful) {
                                Toast.makeText(
                                    this@ViajeAmigosConductor,
                                    "Viaje enviado",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                val errorBody = response.errorBody()
                                val errorMessage = errorBody?.string()
                                Toast.makeText(
                                    this@ViajeAmigosConductor,
                                    "Error al enviar viaje: $errorMessage",
                                    Toast.LENGTH_SHORT
                                ).show()

                            }
                        }
                        override fun onFailure(call: Call<RutaData>, t: Throwable) {
                            val errorMessage = t.message
                            Toast.makeText(this@ViajeAmigosConductor, "Error al enviar viaje: $errorMessage", Toast.LENGTH_SHORT).show()
                        }
                    })

                } else {
                    Toast.makeText(this@ViajeAmigosConductor, "Error en la solicitud", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                Toast.makeText(this@ViajeAmigosConductor, "Error en la solicitud", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
