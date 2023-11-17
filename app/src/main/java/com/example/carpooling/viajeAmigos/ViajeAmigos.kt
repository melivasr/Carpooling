package com.example.carpooling.viajeAmigos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.carpooling.R
import com.example.model.AmigoViaje
import com.example.retrofit.AmigoViajeApi
import com.example.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViajeAmigos : AppCompatActivity() {
    /**
     * Método llamado cuando la actividad se crea.
     *
     * @param savedInstanceState Datos que pueden ser utilizados para restablecer el estado de la actividad.
     */
    val apiService = RetrofitService().getRetrofit().create(AmigoViajeApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carpooling)

        val correo = intent.getStringExtra("email").toString()
        val ubicacion = intent.getStringExtra("ubicacion").toString()

        val botonAmigo = findViewById<Button>(R.id.botonAmigo)
        botonAmigo.setOnClickListener {
            enviarViaje(correo, ubicacion)
        }
    }
    private fun enviarViaje(correo: String, ubicacion: String) {
        val amigoViaje = AmigoViaje()
        amigoViaje.correo = correo
        amigoViaje.ubicacion = ubicacion

        val call = apiService.save(amigoViaje)
        call.enqueue(object : Callback<AmigoViaje> {
            override fun onResponse(call: Call<AmigoViaje>, response: Response<AmigoViaje>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@ViajeAmigos, "Viaje de amigos solicitado", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@ViajeAmigos, "Error en la solicitud", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<AmigoViaje>, t: Throwable) {
                Toast.makeText(this@ViajeAmigos, "Error en la solicitud", Toast.LENGTH_SHORT).show()
            }
        })
    }

}