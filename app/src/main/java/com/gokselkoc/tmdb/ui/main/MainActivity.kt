package com.gokselkoc.tmdb.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var navHostFragment: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        navHostFragment =
            supportFragmentManager.findFragmentById(binding.mainFragmentNavHost.id) as NavHostFragment
        navController = navHostFragment.navController

        bottomMenuNavGraph(binding.mainBottomMenuNav)

        binding.mainBottomMenuNav.setOnItemReselectedListener {

            when (it.itemId) {
                R.id.home_nav_graph -> {
                    navController.popBackStack(R.id.homeFragment, false)
                }
                R.id.movies_nav_graph -> {
                    navController.popBackStack(R.id.moviesFragment, false)
                }
                R.id.tv_shows_nav_graph -> {
                    navController.popBackStack(R.id.tvShowsFragment, false)
                }
                R.id.profile_nav_graph -> {
                    navController.popBackStack(R.id.profileFragment, false)
                }
            }
        }
    }

    private fun bottomMenuNavGraph(bottomMenuView: BottomNavigationView) {
        bottomMenuView.setupWithNavController(navController)
    }
}