package com.example.previsaodotempo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PrevisaoAdapter(private val previsoes: List<PrevisaoDoTempo>) :
    RecyclerView.Adapter<PrevisaoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewData: TextView = view.findViewById(R.id.textViewData)
        val textViewTemperatura: TextView = view.findViewById(R.id.textViewTemperatura)
        val textViewUmidade: TextView = view.findViewById(R.id.textViewUmidade)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_previsao, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val previsao = previsoes[position]
        holder.textViewData.text = previsao.data
        holder.textViewTemperatura.text = "Máx: ${previsao.temperaturaMaxima}°C, Mín: ${previsao.temperaturaMinima}°C"
        holder.textViewUmidade.text = "Umidade: ${previsao.umidade}%"
    }

    override fun getItemCount(): Int {
        return previsoes.size
    }

}
