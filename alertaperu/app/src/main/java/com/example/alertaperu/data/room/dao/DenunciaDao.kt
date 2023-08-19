package com.example.alertaperu.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.alertaperu.data.room.entity.DenunciaDB

@Dao
interface DenunciaDao {
    @Query("SELECT * FROM DenunciaDB")
    fun getAll() : MutableList<DenunciaDB>

    @Query("SELECT * FROM DenunciaDB WHERE tituloDenuncia = :tituloDenuncia")
    fun searchDenuncia(tituloDenuncia: String) : MutableList<DenunciaDB>


    @Query("SELECT * FROM DenunciaDB WHERE idDenuncia = :id")
    fun getDenunciaById(id: Int) : DenunciaDB

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDenuncia(denuncia : DenunciaDB)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(denuncias : MutableList<DenunciaDB>)

    @Query("DELETE FROM DenunciaDB")
    fun deleteAll()

    @Query("DELETE FROM DenunciaDB WHERE idDenuncia = :idDenuncia")
    fun deleteDenuncia(idDenuncia : Int)
}