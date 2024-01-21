package com.example.taller_horario_bus.viewmodels

import androidx.lifecycle.ViewModel
import com.example.taller_horario_bus.database.horario.Horario
import com.example.taller_horario_bus.database.horario.HorarioDao

class HorarioViewModel(private val horarioDao: HorarioDao): ViewModel() {
    fun obtenerListadoHorario(): List<Horario> = horarioDao.obtenerTodos()

    fun obtenerListaParada(nombre:String):List<Horario> = horarioDao.obtenerPorNombreParada(nombre)
}