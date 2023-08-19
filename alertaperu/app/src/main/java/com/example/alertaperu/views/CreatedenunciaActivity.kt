package com.example.alertaperu.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alertaperu.R
import com.example.alertaperu.data.room.AlertaPeruDB
import com.example.alertaperu.data.room.entity.DenunciaDB
import com.example.alertaperu.databinding.ActivityCreatedenunciaBinding

class CreatedenunciaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreatedenunciaBinding
    private lateinit var database: AlertaPeruDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatedenunciaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initValues()
    }

    private fun initValues() {
        database = AlertaPeruDB.getInstancia(this)

        binding.btnGuardar.setOnClickListener {
            var denunciaDB = DenunciaDB()
            denunciaDB.tituloDenuncia = binding.edtTitulo.text.toString().trim()
            denunciaDB.descripcionDenuncia = binding.edtDescripcion.text.toString().trim()
            denunciaDB.distritoDenuncia = binding.edtDistrito.text.toString().trim()
            denunciaDB.direccionDenuncia = binding.edtDireccion.text.toString().trim()

            if(binding.edtTitulo.text.toString().isEmpty() || binding.edtDescripcion.text.toString().isEmpty()
                || binding.edtDistrito.text.toString().isEmpty()){

                Toast.makeText(this, "DEBE LLENAR TODOS LOS CAMPOS", Toast.LENGTH_SHORT).show()

            }else {
                database.denunciaDao().insertDenuncia(denunciaDB)
                mensajeGuardar()
            }
        }

    }

    private fun mensajeGuardar(){
        AlertDialog.Builder(this)
            .setTitle("Guardar Denuncia")
            .setMessage("Se ha creado la denuncia correctamente.")
            .setNeutralButton("Ok") { dialog , _ ->
                finish()
            }
            .setCancelable(false)
            .show()
    }
}