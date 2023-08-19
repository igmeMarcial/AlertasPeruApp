package com.example.alertaperu.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.alertaperu.model.NumerosUtiles
import com.example.alertaperu.R

class NumerosUtilesAdapter(private val numerosUtilesList: List<NumerosUtiles>) :
    RecyclerView.Adapter<NumerosUtilesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_numeros_utiles, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val numerosUtiles = numerosUtilesList[position]
        Glide.with(holder.itemView.context)
            .load(numerosUtiles.imagenUrl)
            .into(holder.ivImagen)
        holder.tvTipo.text = numerosUtiles.tipo
        holder.tvNombre.text = numerosUtiles.nombre
        holder.tvNumero.text = numerosUtiles.numero

        holder.tvNumero.setOnClickListener {
            val phoneNumber = numerosUtiles.numero
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return numerosUtilesList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImagen: ImageView = itemView.findViewById(R.id.ivImagen)
        val tvTipo: TextView = itemView.findViewById(R.id.tvTipo)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvNumero: TextView = itemView.findViewById(R.id.tvNúmero)
    }
}