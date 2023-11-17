package com.example.retrofit

import com.example.model.AmigoViaje
import com.example.model.EmpleadoViaje
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface AmigoViajeApi {
    @GET("/usuario/get-all-viajes")
    fun getAllViajes(): Call<List<AmigoViaje>>

    @POST("/viaje/save-viajes")
    fun save(@Body amigoViaje: AmigoViaje): Call<AmigoViaje>

    @GET("/viaje/get-viaje")
    fun getViaje(): Call<AmigoViaje>

    @GET("/viaje/get-amigos")
    fun getAmigos(): Call<List<String>>

}
