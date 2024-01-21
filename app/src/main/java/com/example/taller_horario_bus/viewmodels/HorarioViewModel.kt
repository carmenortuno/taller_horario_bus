package com.example.taller_horario_bus.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.taller_horario_bus.database.horario.Horario
import com.example.taller_horario_bus.database.horario.HorarioDao
import java.lang.IllegalArgumentException

class HorarioViewModel(private val horarioDao: HorarioDao): ViewModel() {
    fun obtenerListadoHorario(): List<Horario> = horarioDao.obtenerTodos()

    fun obtenerListaParada(nombre:String):List<Horario> = horarioDao.obtenerPorNombreParada(nombre)
}

//La calase hereda de ViewModelProvider.Factory
class HorarioViewModelFactory(private val horarioDao:HorarioDao): ViewModelProvider.Factory{

    override fun<T:ViewModel> create(modelClass:Class<T>):T{
        if(modelClass.isAssignableFrom(HorarioViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return HorarioViewModel(horarioDao) as T
        }
        throw IllegalArgumentException("Clase de ViewModel desconocida")
    }

}