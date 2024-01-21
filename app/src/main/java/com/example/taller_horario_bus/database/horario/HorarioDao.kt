package com.example.taller_horario_bus.database.horario

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HorarioDao {
    @Insert
    suspend fun insertar(horario: Horario)

    @Query("SELECT * FROM horario_bus ORDER BY hora_llegada ASC")
    fun obtenerTodos(): List<Horario>

    @Query("SELECT * FROM horario_bus WHERE nombre_parada = :nombreParada ORDER BY hora_llegada ASC")
    fun obtenerPorNombreParada(nombreParada: String): List<Horario>


}