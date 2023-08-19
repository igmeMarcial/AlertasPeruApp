package com.example.alertaperu.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alertaperu.R
import com.example.alertaperu.data.room.entity.DenunciaDB

class ListDenunciaAdapter (
    var items: MutableList<DenunciaDB>,
    var iDenuncia : IDenuncia
 ): RecyclerView.Adapter<ListDenunciaAdapter.ViewHolder>() {

    interface IDenuncia {
        fun onDenunciaClick(denunciaDB: DenunciaDB)
        fun onDenunciaLongClick(denunciaDB: DenunciaDB)
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener, View.OnLongClickListener {
        val tvTitulo : TextView = itemView.findViewById(R.id.tvTitulo)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescripcion)
        val tvDistrito : TextView = itemView.findViewById(R.id.tvDistrito)
        val tvDireccion : TextView = itemView.findViewById(R.id.tvDireccion)
      
        init{
            itemView.setOnClickListener (this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            iDenuncia.onDenunciaClick(items[adapterPosition])
        }

        override fun onLongClick(v: View?): Boolean {
            iDenuncia.onDenunciaLongClick(items[adapterPosition])
            return true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_denuncias, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.tvTitulo.text = item.tituloDenuncia
        holder.tvDescripcion.text = item.descripcionDenuncia
        holder.tvDistrito.text = item.distritoDenuncia
        holder.tvDireccion.text = item.direccionDenuncia

    }

    fun update(newItems : List<DenunciaDB>){
        this.items.clear()
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }
}