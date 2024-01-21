package com.example.taller_horario_bus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.room.Room
import com.example.taller_horario_bus.database.AppDatabase
import com.example.taller_horario_bus.database.horario.Horario

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO VIEWBINDING
        //Ejemplo de uso de base de datos:

        val db = Room.databaseBuilder(applicationContext,
            AppDatabase:: class.java,"horarios-busDB"
        ).build()

        val horarioDao=db.horarioDao()

        suspend { horarioDao.insertar(Horario(1,"Glorieta",45545))}

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}