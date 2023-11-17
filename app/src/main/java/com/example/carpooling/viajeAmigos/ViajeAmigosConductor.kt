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
/**
 * Actividad para gestionar el viaje con amigos en el rol de conductor.
 */
class ViajeAmigosConductor : AppCompatActivity() {

    // Instancias de las interfaces de las API
    private lateinit var apiService: AmigoViajeApi
    private lateinit var apiService2: RutaApi
    /**
     * Método llamado cuando la actividad se crea.
     *
     * @param savedInstanceState Datos que pueden ser utilizados para restablecer el estado de la actividad.
     */
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
    /**
     * Obtiene la lista de amigos y realiza acciones adicionales.
     */
    private fun obtenerViajes() {
        // Realiza la llamada a la API para obtener la lista de amigos
        val call = apiService.getAmigos()
        call.enqueue(object : Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if (response.isSuccessful) {
                    // Procesa la lista de amigos
                    val viajes = response.body()
                    val ubicacion = intent.getStringExtra("ubicacion")
                    val mutableViajes = viajes?.toMutableList()

                    // Agregar "1" al inicio de la lista
                    mutableViajes?.add(0, ubicacion.toString())

                    // Agregar "33" al final de la lista
                    mutableViajes?.add("33")

                    // Convierte la lista a String y crea un objeto RutaData
                    val ruta = mutableViajes?.toList()
                    val rutaData = RutaData(ruta.toString())

                    // Muestra un mensaje de solicitud enviada
                    Toast.makeText(this@ViajeAmigosConductor, "Solicitud enviada", Toast.LENGTH_SHORT).show()

                    // Realiza la llamada a la API para guardar la ruta
                    val call2 = apiService2.save(rutaData)
                    call2.enqueue(object : Callback<RutaData> {
                        override fun onResponse(
                            call: Call<RutaData>,
                            response: Response<RutaData>
                        ) {
                            if (response.isSuccessful) {
                                // Muestra un mensaje de éxito al enviar el viaje
                                Toast.makeText(
                                    this@ViajeAmigosConductor,
                                    "Viaje enviado",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                // Muestra un mensaje de error al enviar el viaje
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
                            // Muestra un mensaje de error en caso de fallo
                            val errorMessage = t.message
                            Toast.makeText(this@ViajeAmigosConductor, "Error al enviar viaje: $errorMessage", Toast.LENGTH_SHORT).show()
                        }
                    })

                } else {
                    // Muestra un mensaje de error en caso de respuesta no exitosa
                    Toast.makeText(this@ViajeAmigosConductor, "Error en la solicitud", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                // Muestra un mensaje de error en caso de fallo en la llamada a la API
                Toast.makeText(this@ViajeAmigosConductor, "Error en la solicitud", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
