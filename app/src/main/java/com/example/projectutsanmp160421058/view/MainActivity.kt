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
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.projectutsanmp160421058.R
import com.example.projectutsanmp160421058.databinding.ActivityMainBinding
import com.example.projectutsanmp160421058.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    companion object {
        fun getSharedPref(activity: Activity): String? {
            val shared = activity.packageName
            val sharedPref: SharedPreferences = activity.getSharedPreferences(shared, Context.MODE_PRIVATE)
            val res = sharedPref.getString("KEY_USER", "")
            Log.d("cek", res.toString())

            return res
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        navController = (supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this, navController)

        if (getSharedPref(this) != "") {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

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