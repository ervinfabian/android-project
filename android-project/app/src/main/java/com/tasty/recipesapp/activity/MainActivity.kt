package com.tasty.recipesapp.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tasty.recipesapp.R
import android.util.Log
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tasty.recipesapp.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment


// a containerbe betoltom a fragmenteket
// a graphot ossze kell kossem a graphhal ami navigal
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)








    //    Retrieve the message from the Intent
//        val message = intent.getStringExtra("message")
//        binding.textViewMain.text = message // Display the message

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: MainActivity started.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: MainActivity resumed.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: MainActivity paused.")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: MainActivity stopped.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: MainActivity restarted.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: MainActivity destroyed.")
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment_activity_main, fragment)
        transaction.commit()
    }
}