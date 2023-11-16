package com.example.carpooling.Amigos

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carpooling.R
import com.example.retrofit.EmpleadoViajeApi
import com.example.retrofit.RetrofitService
import com.example.retrofit.UsuarioApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnadirAmigos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_amigos)

        val apiService = RetrofitService().getRetrofit().create(UsuarioApi::class.java)

        val call = apiService.getUsuariosRegistrados()

        call.enqueue(object : Callback<List<Any>> {
            override fun onResponse(call: Call<List<Any>>, response: Response<List<Any>>) {
                if (response.isSuccessful) {
                    // Manejar la respuesta exitosa
                    val usuarios: List<List<Any>> = response.body() as List<List<Any>>
                    val nombres = usuarios.map { it[0] }

                } else {
                    // Manejar el error
                }
            }

            override fun onFailure(call: Call<List<Any>>, t: Throwable) {
                // Manejar el fallo de la llamada a la API
            }
        })
    }
}

