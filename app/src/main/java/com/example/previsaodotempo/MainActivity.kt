package com.example.previsaodotempo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.previsaodotempo.R
import com.example.previsaodotempo.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var previsaoAdapter: PrevisaoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewPrevisao)
        recyclerView.layoutManager = LinearLayoutManager(this)

        carregarDadosDoTempo()
    }

    private fun carregarDadosDoTempo() {
        val call = RetrofitClient.api.getPrevisaoDoTempo()
        call.enqueue(object : Callback<List<PrevisaoDoTempo>> {
            override fun onResponse(call: Call<List<PrevisaoDoTempo>>, response: Response<List<PrevisaoDoTempo>>) {
                if (response.isSuccessful) {
                    val previsoes = response.body()!!
                    previsaoAdapter = PrevisaoAdapter(previsoes)
                    recyclerView.adapter = previsaoAdapter
                }
            }

            override fun onFailure(call: Call<List<PrevisaoDoTempo>>, t: Throwable) {
            }
        })
    }
}

