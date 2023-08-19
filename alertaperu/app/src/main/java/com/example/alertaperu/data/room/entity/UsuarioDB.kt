package com.example.alertaperu.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class UsuarioDB(
    @PrimaryKey(autoGenerate = true)
    var idUsuario : Int = 0,
    var nombreUsuario : String = "",
    var apellidoUsuario : String = "",
    var telefono : String = "",
    var email : String = ""
)
