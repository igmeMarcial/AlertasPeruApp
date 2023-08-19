package com.example.alertaperu.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.alertaperu.R
import com.example.alertaperu.views.CreatedenunciaActivity
import com.example.alertaperu.views.ListaDenunciaActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AlertaPeruFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AlertaPeruFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val view = inflater.inflate(R.layout.fragment_alerta_peru, container, false)

        val BtnRealizarDenuncia = view.findViewById<Button>(R.id.btnRealizarDenuncia)
        val BtnVermisDenuncias = view.findViewById<Button>(R.id.btnVermisDenuncias)


        BtnRealizarDenuncia.setOnClickListener {
            val intent = Intent(activity, CreatedenunciaActivity::class.java)
            startActivity(intent)
        }

        BtnVermisDenuncias.setOnClickListener{
            val intent = Intent(activity,ListaDenunciaActivity::class.java)
            startActivity(intent)
        }
        return view
    }

}