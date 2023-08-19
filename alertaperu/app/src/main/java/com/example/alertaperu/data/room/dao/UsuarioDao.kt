package com.example.alertaperu.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.alertaperu.data.room.entity.UsuarioDB

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM UsuarioDB")
    fun getAll() : MutableList<UsuarioDB>

    @Query("SELECT * FROM UsuarioDB WHERE idUsuario = :id")
    fun getUsuarioById(id: Int) : UsuarioDB

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsuario(pais : UsuarioDB)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(usuarios : MutableList<UsuarioDB>)

    @Query("DELETE FROM UsuarioDB")
    fun deleteAll()

    @Query("DELETE FROM UsuarioDB WHERE idUsuario = :idUsuario")
    fun deleteUsuarioById(idUsuario : Int)
}