package com.example.previsaodotempo

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("wheater.json")
    fun getPrevisaoDoTempo(): Call<List<PrevisaoDoTempo>>
}
