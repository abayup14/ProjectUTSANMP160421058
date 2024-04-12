package com.example.projectutsanmp160421058.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.projectutsanmp160421058.R
import com.example.projectutsanmp160421058.databinding.ActivityMainBinding
import com.example.projectutsanmp160421058.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        navController = (supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this, navController)

//        binding.bottomNav.setupWithNavController(navController)

//        hideNavBars()
    }

    override fun onSupportNavigateUp(): Boolean {
//        return super.onSupportNavigateUp()
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

//    fun hideNavBars() {
//        navController.addOnDestinationChangedListener {_, destination, _ ->
//            when (destination.id) {
//                R.id.loginFragment -> {
//                    binding.bottomNav.visibility = View.GONE
//                }
//                R.id.registerFragment -> {
//                    binding.bottomNav.visibility = View.GONE
//                }
//                else -> {
//                    binding.bottomNav.visibility = View.VISIBLE
//                }
//            }
//        }
//    }
}