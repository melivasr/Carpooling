package com.example.carpooling.calificaciones

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carpooling.Amigos.UsuarioAdapterUsuario
import com.example.carpooling.R
import com.example.retrofit.RetrofitService
import com.example.retrofit.UsuarioApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class calificaciones : AppCompatActivity() {

    private lateinit var recyclerView2: RecyclerView
    private lateinit var adapter: AdapterCalificaciones

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calificaciones)

        recyclerView2 = findViewById(R.id.recyclerView2)

        val apiService = RetrofitService().getRetrofit().create(UsuarioApi::class.java)

        val call = apiService.getUsuariosRegistrados()

        call.enqueue(object : Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if (response.isSuccessful) {
                    // Manejar la respuesta exitosa
                    val usuarios = response.body()
                    // Hacer algo con los usuarios
                    setupRecyclerView(usuarios)
                } else {
                    // Manejar el error
                    println("Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                // Manejar el fallo de la llamada a la API
                println("Error de red: ${t.message}")
            }
        })
    }

    private fun setupRecyclerView(usuarios: List<String>?) {
        adapter = AdapterCalificaciones(usuarios ?: emptyList(), object : AdapterCalificaciones.CalificacionesItemClickListener {
            override fun onAccionButtonClick(usuario: String, context: Context) {
                val intent = Intent(context, CalificacionEstrellas::class.java)
                // Implementar la lógica de clic del botón aquí
            }
        })

        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView2.adapter = adapter
    }
}
