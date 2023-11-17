package com.example.carpooling.viajeAmigos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.carpooling.R
import com.example.model.TravelData
import com.example.model.TravelRequestData
import com.example.model.Usuario
import com.example.retrofit.GeographicDataApi
import com.example.retrofit.RetrofitService
import com.example.retrofit.UsuarioApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
/**
 * Actividad para mostrar la ruta de un viaje.
 */
class MostrarRuta: AppCompatActivity() {
    /**
     * Método llamado cuando se crea la actividad.
     *
     * @param savedInstanceState Estado de la instancia guardado.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_ruta)
        // Inicializar las instancias de las API necesarias
        val userApi = RetrofitService().getRetrofit().create(UsuarioApi::class.java)
        val geographicDataApi =
            RetrofitService().getRetrofit().create(GeographicDataApi::class.java)

        // Obtener datos del Intent
        val correo = intent.getStringExtra("email").toString()
        val id = intent.getStringExtra("id");

        // Consultar el usuario usando la API de usuarios
        userApi.getUser(correo).enqueue(object : Callback<Int> {
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {

                    // Obtener el usuario de la respuesta
                    val usuario = response.body()
                    if (usuario != null) {

                        // Crear datos de solicitud de viaje
                        val travelRequestData = TravelRequestData(usuario, listOf(3, 4, 6))

                        // Consultar datos geográficos usando la API de datos geográficos
                        geographicDataApi.getRegistrados(travelRequestData)
                            .enqueue(object : Callback<TravelData> {
                                override fun onResponse(
                                    call: Call<TravelData>,
                                    response: Response<TravelData>
                                ) {
                                    if (response.isSuccessful) {
                                        // Obtener los datos del viaje de la respuesta
                                        val travelData = response.body()

                                        // Actualizar la interfaz de usuario con la información del viaje
                                        val textView = findViewById<TextView>(R.id.mostrarRuta)
                                        textView.text = travelData.toString()
                                    }
                                }

                                override fun onFailure(call: Call<TravelData>, t: Throwable) {
                                    // Manejar la falla en la consulta de datos geográficos
                                }
                            })
                    }
                }
            }

            override fun onFailure(call: Call<Int>, t: Throwable) {
                // Manejar la falla en la consulta del usuario
            }
        })
    }
}

