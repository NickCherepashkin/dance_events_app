package com.drozdova.danceevents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.drozdova.danceevents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        binding.btmNavigation.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.calendar, R.id.events,  R.id.search, R.id.favorites)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp(appBarConfiguration)
//    }
}