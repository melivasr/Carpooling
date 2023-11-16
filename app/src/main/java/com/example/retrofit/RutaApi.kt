package com.example.retrofit;

import com.example.model.RutaData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RutaApi {
    @POST("/ruta/save")
    fun save(@Body rutaData: RutaData): Call<RutaData>
}
