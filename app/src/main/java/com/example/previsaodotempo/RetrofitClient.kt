package com.example.previsaodotempo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val api: APIService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/alexandrefelipemuller/fakeBackend/main/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(APIService::class.java)
    }
}
