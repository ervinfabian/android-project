package com.tasty.recipesapp.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tasty.recipesapp.R
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import com.tasty.recipesapp.databinding.ActivityMainBinding
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController


// a containerbe betoltom a fragmenteket
// a graphot ossze kell kossem a graphhal ami navigal
class MainActivity : AppCompatActivity() {

    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)

//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.recipesFragment, R.id.profileFragment))
//        setupActionBarWithNavController(navController, appBarConfiguration)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //val navView: BottomNavigationView = binding.navView
//        val navController = findNavController(R.id.nav_host_fragment)
//        val navView: BottomNavigationView = binding.bottomNavigation
//        navView.setupWithNavController(navController)
    //    Retrieve the message from the Intent
//        val message = intent.getStringExtra("message")
//        binding.textViewMain.text = message // Display the message

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        val navGraph = navController.graph

        // Find the action ID corresponding to the selected menu item
        val actionId = navGraph.findNode(item.itemId)?.id

        return if (actionId != null) {
            navController.navigate(actionId)
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }




    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart: MainActivity started.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume: MainActivity resumed.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause: MainActivity paused.")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop: MainActivity stopped.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart: MainActivity restarted.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy: MainActivity destroyed.")
    }

//    private fun replaceFragment(fragment: Fragment) {
//        val fragmentManager = supportFragmentManager
//        val transaction = fragmentManager.beginTransaction()
//        transaction.replace(R.id.nav_host_fragment, fragment)
//        transaction.commit()
//    }
}