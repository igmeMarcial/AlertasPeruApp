package com.example.alertaperu.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alertaperu.R
import com.example.alertaperu.data.room.AlertaPeruDB
import com.example.alertaperu.data.room.entity.DenunciaDB
import com.example.alertaperu.databinding.ActivityCreatedenunciaBinding
import com.example.alertaperu.databinding.ActivityListaDenunciaBinding

class ListaDenunciaActivity : AppCompatActivity(), ListDenunciaAdapter.IDenuncia {

    private lateinit var binding: ActivityListaDenunciaBinding
    private var lstDenuncias : MutableList<DenunciaDB> = ArrayList()
    private lateinit var database : AlertaPeruDB
    private lateinit var denunciaAdapter : ListDenunciaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaDenunciaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initValues()
    }

    override fun onResume(){
        super.onResume()
        denunciaAdapter.update(database.denunciaDao().getAll())
    }

    private fun initValues(){

        database = AlertaPeruDB.getInstancia(this)

        database.denunciaDao().insert(lstDenuncias)

        denunciaAdapter = ListDenunciaAdapter(database.denunciaDao().getAll(), this)

        binding.rvDenuncias.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvDenuncias.adapter = denunciaAdapter

    }

    override fun onDenunciaClick(denunciaDB: DenunciaDB) {
       TODO()
    }

    override fun onDenunciaLongClick(denunciaDB: DenunciaDB) {
        AlertDialog.Builder(this)
            .setTitle("Eliminar Denuncia")
            .setMessage("¿Deseas eliminar la denuncia ${denunciaDB.tituloDenuncia}?")
            .setPositiveButton("SÍ") { _ ,_ ->
                database.denunciaDao().deleteDenuncia(denunciaDB.idDenuncia)
                denunciaAdapter.update(database.denunciaDao().getAll())
            }
            .setNegativeButton("NO"){ _, _ ->

            }
            .setCancelable(false)
            .show()
    }
}