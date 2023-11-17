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

        val geographicDataApi =
            RetrofitService().getRetrofit().create(GeographicDataApi::class.java)
        val correo = intent.getStringExtra("email").toString()
        val travelRequestData = TravelRequestData(correo, listOf(3, 4, 6))
        geographicDataApi.getRegistrados(travelRequestData)
            .enqueue(object : Callback<TravelData> {
                override fun onResponse(
                    call: Call<TravelData>,
                    response: Response<TravelData>
                ) {
                    if (response.isSuccessful) {
                        val travelData = response.body()


                        val textView = findViewById<TextView>(R.id.mostrarRuta)
                        textView.text = travelData.toString()
                    }
                }

                override fun onFailure(call: Call<TravelData>, t: Throwable) {
                    // handle failure
                }
            })

    }
}