package com.example.projectutsanmp160421058.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.projectutsanmp160421058.R
import com.example.projectutsanmp160421058.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    private lateinit var navController: NavController

    companion object {
        fun logout(activity: Activity) {
            var shared = activity.packageName
            var sharedPref: SharedPreferences = activity.getSharedPreferences(shared, Context.MODE_PRIVATE)
            var editor = sharedPref.edit()
            editor.remove("KEY_USER")
            editor.apply()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        navController = (supportFragmentManager.findFragmentById(R.id.navHome) as NavHostFragment).navController
        val appBarConfig = AppBarConfiguration(setOf(
            R.id.itemHome,
            R.id.itemHistory,
            R.id.itemProfile
        ))

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig)
        binding.bottomNav.setupWithNavController(navController)

        if (MainActivity.getSharedPref(this) == "") {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        hideNavBars()
    }

    override fun onSupportNavigateUp(): Boolean {
//        return super.onSupportNavigateUp()
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun hideNavBars() {
    navController.addOnDestinationChangedListener {_, destination, _ ->
        when (destination.id) {
            R.id.detailFragment -> {
                binding.bottomNav.visibility = View.GONE
            }
            else -> {
                binding.bottomNav.visibility = View.VISIBLE
            }
        }
    }
}
}