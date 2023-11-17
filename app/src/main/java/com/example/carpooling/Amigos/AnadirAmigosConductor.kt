package com.example.carpooling.Amigos

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carpooling.R
import com.example.retrofit.RetrofitService
import com.example.retrofit.UsuarioApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
/**
 * Actividad para añadir amigos como conductor.
 */
class AnadirAmigosConductor : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UsuarioAdapterConductor
    /**
     * Método llamado cuando se crea la actividad.
     *
     * @param savedInstanceState Estado previamente guardado de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_amigos_conductor)

        recyclerView = findViewById(R.id.recyclerView)

        val apiService = RetrofitService().getRetrofit().create(UsuarioApi::class.java)

        val call = apiService.getUsuariosRegistrados()

        call.enqueue(object : Callback<List<String>> {
            /**
             * Método llamado cuando la respuesta de la API es exitosa.
             *
             * @param call Objeto de llamada a la API.
             * @param response Respuesta de la API que contiene la lista de usuarios.
             */
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
            /**
             * Método llamado cuando hay un fallo en la llamada a la API.
             *
             * @param call Objeto de llamada a la API.
             * @param t Objeto Throwable que representa el fallo.
             */
            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                // Manejar el fallo de la llamada a la API
                println("Error de red: ${t.message}")
            }
        })
    }
    /**
     * Configura el RecyclerView con la lista de usuarios.
     *
     * @param usuarios Lista de usuarios para mostrar.
     */
    private fun setupRecyclerView(usuarios: List<String>?) {
        adapter = UsuarioAdapterConductor(usuarios ?: emptyList(), object : UsuarioAdapterConductor.UsuarioAdapterConductorItemClickListener {
            /**
             * Método llamado cuando se hace clic en el botón de acción.
             *
             * @param usuario Nombre del usuario seleccionado.
             */
            override fun onAccionButtonClick(usuario: String) {
                // Implementar la lógica de clic del botón aquí
            }
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
