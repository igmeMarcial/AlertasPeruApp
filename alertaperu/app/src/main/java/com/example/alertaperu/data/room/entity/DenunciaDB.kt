package com.example.alertaperu.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class DenunciaDB(
    @PrimaryKey(autoGenerate = true)
    var idDenuncia : Int = 0,
    var tituloDenuncia : String = "",
    var descripcionDenuncia : String = "",
    var distritoDenuncia : String = "",
    var direccionDenuncia : String = "",
    var idUsuario : Int = 0
)
