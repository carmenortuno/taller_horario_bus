package com.example.taller_horario_bus

import android.app.Application
import com.example.taller_horario_bus.database.AppDatabase

class HorarioBusApplication: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDataBase(this)}
}