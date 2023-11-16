package com.example.retrofit

import com.example.model.EmpleadoViaje
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface EmpleadoViajeApi {
    @GET("/usuario/get-all")
    fun getAllViajes(): Call<List<EmpleadoViaje>>

    @POST("/viaje/save")
    fun save(@Body empleadoViaje: EmpleadoViaje): Call<EmpleadoViaje>

    @GET("/viaje/get")
    fun getViaje(): Call<EmpleadoViaje>
}
