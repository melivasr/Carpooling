package com.example.carpooling.calificaciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carpooling.R
import com.example.retrofit.RetrofitService
import com.example.retrofit.UsuarioApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class calificaciones: AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterCalificaciones

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calificaciones)

        recyclerView = findViewById(R.id.recyclerView)

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
        adapter = AdapterCalificaciones(usuarios ?: emptyList(), object : AdapterCalificaciones.UsuarioItemClickListener {
            override fun onAccionButtonClick(usuario: String) {
                // Implementar la lógica de clic del botón aquí
            }
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}

