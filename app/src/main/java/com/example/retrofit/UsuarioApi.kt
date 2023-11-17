package com.example.retrofit

import com.example.model.Usuario
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface UsuarioApi {

    @GET("/usuario/get-all")
    fun getAllUsuarios(): Call<List<Usuario>>

    @POST("/usuario/save")
    fun save(@Body usuario: Usuario): Call<Usuario>

    @GET("/usuario/correo")
    fun getUser(@Query("correo") correo: String): Call<Int>
    @GET("/usuario/login")
    fun getUsuario(@Query("correo") correo: String, @Query("password") password: String): Call<Usuario>

    @GET("/usuario/get-registrados")
    fun getUsuariosRegistrados(): Call<List<String>>

}

