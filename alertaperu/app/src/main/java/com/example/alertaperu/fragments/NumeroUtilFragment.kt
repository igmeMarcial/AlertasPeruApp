package com.example.alertaperu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alertaperu.model.NumerosUtiles
import com.example.alertaperu.R
import com.google.firebase.firestore.FirebaseFirestore
import com.example.alertaperu.adapter.NumerosUtilesAdapter



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class NumeroUtilFragment : Fragment() {

    private lateinit var firestore: FirebaseFirestore
    private val numerosUtilesList = arrayListOf<NumerosUtiles>()

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_numero_util, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.listaNumerosUtiles)

        val adapter = NumerosUtilesAdapter(numerosUtilesList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        firestore = FirebaseFirestore.getInstance()

        firestore.collection("numeros_utiles").get()
            .addOnSuccessListener { documentList ->
                for (document in documentList) {
                    val tipo = document.getString("tipo")
                    val nombre = document.getString("nombre")
                    val numero = document.getString("numero")
                    val imagenUrl = document.getString("imagenUrl")

                    if (tipo != null && nombre != null && numero != null && imagenUrl != null) {
                        val numeroUtil = NumerosUtiles(tipo, nombre, numero, imagenUrl)
                        numerosUtilesList.add(numeroUtil)
                    }
                }
                adapter.notifyDataSetChanged()
            }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NumeroUtilFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}