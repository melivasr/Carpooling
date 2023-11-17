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
/**
 * Actividad para gestionar el viaje con amigos.
 */
class ViajeAmigos : AppCompatActivity() {

    // Instancia de la interfaz de la API de AmigoViaje
    val apiService = RetrofitService().getRetrofit().create(AmigoViajeApi::class.java)
    /**
     * Método llamado cuando la actividad se crea.
     *
     * @param savedInstanceState Datos que pueden ser utilizados para restablecer el estado de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carpooling)

        // Obtener datos del Intent
        val correo = intent.getStringExtra("email").toString()
        val ubicacion = intent.getStringExtra("ubicacion").toString()

        // Configurar el botón de amigos y establecer el listener
        val botonAmigo = findViewById<Button>(R.id.botonAmigo)
        botonAmigo.setOnClickListener {
            enviarViaje(correo, ubicacion)
        }
    }
    /**
     * Envia la solicitud de viaje de amigos.
     *
     * @param correo Correo electrónico del usuario.
     * @param ubicacion Ubicación del usuario.
     */
    private fun enviarViaje(correo: String, ubicacion: String) {
        // Crear objeto AmigoViaje con los datos
        val amigoViaje = AmigoViaje()
        amigoViaje.correo = correo
        amigoViaje.ubicacion = ubicacion

        // Realizar la llamada a la API para guardar el viaje de amigos
        val call = apiService.save(amigoViaje)
        call.enqueue(object : Callback<AmigoViaje> {
            override fun onResponse(call: Call<AmigoViaje>, response: Response<AmigoViaje>) {
                if (response.isSuccessful) {
                    // Mostrar mensaje de éxito
                    Toast.makeText(this@ViajeAmigos, "Viaje de amigos solicitado", Toast.LENGTH_SHORT).show()
                } else {
                    // Mostrar mensaje de error
                    Toast.makeText(this@ViajeAmigos, "Error en la solicitud", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<AmigoViaje>, t: Throwable) {
                // Mostrar mensaje de error en caso de falla
                Toast.makeText(this@ViajeAmigos, "Error en la solicitud", Toast.LENGTH_SHORT).show()
            }
        })
    }

}