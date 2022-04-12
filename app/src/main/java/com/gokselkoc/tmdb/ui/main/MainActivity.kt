package com.gokselkoc.tmdb.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.gokselkoc.tmdb.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomMenuNavGraph(binding.mainFragmentNavHost.id, binding.mainBottomMenuNav)

    }


    private fun bottomMenuNavGraph(navHostFragmentId: Int, bottomMenuView: BottomNavigationView) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment
        val navController = navHostFragment.navController
        bottomMenuView.setupWithNavController(navController)

    }


}