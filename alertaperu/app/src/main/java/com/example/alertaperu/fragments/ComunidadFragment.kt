package com.example.alertaperu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alertaperu.R
import com.example.alertaperu.adapter.AdapterDenuncia
import com.example.alertaperu.databinding.FragmentComunidadBinding
import com.example.alertaperu.model.Denuncia
import com.google.api.Distribution.BucketOptions.Linear
import com.google.firebase.firestore.FirebaseFirestore

class ComunidadFragment : Fragment() {

    private var _binding : FragmentComunidadBinding? = null
    private val binding get() = _binding!!

    val db = FirebaseFirestore.getInstance()
    private lateinit var adapterDenuncia: AdapterDenuncia
    private lateinit var listDenuncia: ArrayList<Denuncia>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentComunidadBinding.inflate(inflater, container, false)

        leerDatos()  // Llama a leerDatos() antes de devolver la vista

        return binding.root
    }

    private fun leerDatos() {
        listDenuncia = ArrayList()
        adapterDenuncia = AdapterDenuncia((listDenuncia))
        db.collection("denuncia")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents){
                    val wallItem = document.toObject(Denuncia::class.java)
                    wallItem.img = document["imagen"].toString()
                    wallItem.titulo = document["titulo"].toString()
                    wallItem.distrito = document["distrito"].toString()
                    wallItem.direccion = document["direccion"].toString()
                    wallItem.desc = document["descripcion"].toString()

                    binding.recyclerView.adapter = adapterDenuncia
                    binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
                    listDenuncia.add(wallItem)
                }
            }
    }


}