package com.example.alertaperu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.alertaperu.R
import com.example.alertaperu.model.Denuncia

class AdapterDenuncia(private var items : ArrayList<Denuncia>): RecyclerView.Adapter<AdapterDenuncia.ViewHolder>(){

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvImage: ImageView = itemView.findViewById(R.id.imageView)
        val tvTitulo : TextView = itemView.findViewById(R.id.titulo)
        val tvDitrito : TextView = itemView.findViewById(R.id.distritoDenuncia)
        val tvDireccion : TextView = itemView.findViewById(R.id.direcionDenuncia)
        val tvDescripcion : TextView = itemView.findViewById(R.id.descricpcionDenuncia)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterDenuncia.ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_denuncia, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AdapterDenuncia.ViewHolder, position: Int) {
        val item = items[position]

        Glide.with(holder.itemView.context).load(item.img).into(holder.tvImage)
        holder.tvTitulo.text = item.titulo
        holder.tvDitrito.text = item.distrito
        holder.tvDireccion.text =item.direccion
        holder.tvDescripcion.text = item.desc

    }
}