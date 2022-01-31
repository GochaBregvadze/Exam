package com.example.final_exam_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//        val navView = findViewById<BottomNavigationView>(R.id.bottomNavMenu)
//        val controler = findNavController(R.id.nav_host_fragment)
//
//
//        val appBarConfig = AppBarConfiguration(
//            setOf(
//                R.id.homeFragment,
//                R.id.accountDetails
//            )
//        )
//
//
//        setupActionBarWithNavController(controler, appBarConfig)
//        navView.setupWithNavController(controler)


    }
}