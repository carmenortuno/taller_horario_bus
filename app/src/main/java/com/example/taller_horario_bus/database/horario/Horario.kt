package com.example.taller_horario_bus.database.horario

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Horario(
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo(name = "nombre_parada") val nombreParada: String,
    @NonNull @ColumnInfo(name = "hora_llegada") val horaLlegada: Int
)
