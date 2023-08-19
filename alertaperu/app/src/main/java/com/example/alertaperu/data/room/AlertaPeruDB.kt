package com.example.alertaperu.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.alertaperu.R
import com.example.alertaperu.data.room.dao.DenunciaDao
import com.example.alertaperu.data.room.dao.UsuarioDao
import com.example.alertaperu.data.room.entity.DenunciaDB
import com.example.alertaperu.data.room.entity.UsuarioDB

@Database(
    entities = [
        DenunciaDB::class,
        UsuarioDB::class
    ],
    version =  2,
    exportSchema = false
)
abstract class AlertaPeruDB : RoomDatabase() {
    abstract fun denunciaDao(): DenunciaDao
    abstract fun usuarioDao(): UsuarioDao

    companion object {
        private var instancia: AlertaPeruDB? = null

        @Synchronized
        fun getInstancia(context: Context): AlertaPeruDB {
            if (instancia == null) {
                instancia = Room.databaseBuilder(
                    context, AlertaPeruDB::class.java,
                    context.getString(R.string.database_name)
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }

            return instancia as AlertaPeruDB
        }
    }
}