package com.example.taller_horario_bus.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taller_horario_bus.database.horario.Horario
import com.example.taller_horario_bus.database.horario.HorarioDao

@Database(entities = [Horario::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun horarioDao(): HorarioDao

      companion object {
        private var INSTANCE: AppDatabase? = null;

        fun getDataBase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "horarios-busDB"
                ).build()
                INSTANCE = instance
                // Devolver instancia de base de datos
                instance
            }
        }
    }
}



