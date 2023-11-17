package com.example.retrofit

import com.example.model.TravelData
import com.example.model.TravelRequestData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface GeographicDataApi {

    @GET("/viaje/get-best-path")
    fun getRegistrados(@Body myObject: TravelRequestData): Call<TravelData>


}