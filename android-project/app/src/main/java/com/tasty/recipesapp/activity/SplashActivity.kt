package com.tasty.recipesapp.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tasty.recipesapp.R
import android.util.Log
import androidx.activity.result.launch
import androidx.lifecycle.lifecycleScope
import com.tasty.recipesapp.databinding.ActivitySplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private val TAG = "SplashActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        startActivity(Intent(this, MainActivity::class.java))
//        finish()
//        setContentView(R.layout.activity_splash)
        Log.d(TAG, "onCreate: SplashActivity created.")
        var binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val SPLASH_TIME_OUT: Long = 4000
//
//        binding.buttonSplash.setOnClickListener {
//            val message = binding.editTextSplash.text.toString() // Get input text
//            val intent = Intent(this, MainActivity::class.java)
//            intent.putExtra("message", message) // Pass the input text
//            startActivity(intent) // Navigate to MainActivity
//        }

        // Use a HandlerThread to create a background thread
        val handlerThread = HandlerThread("SplashHandlerThread", -10)
        handlerThread.start() // Create a Handler on the new HandlerThread
        val handler = Handler(handlerThread.looper)
//        val intent = Intent(this, MainActivity::class.java)
//        startActivity(intent)
//        finish() // Optional: Finish SplashActivity to prevent going back

        lifecycleScope.launch {
            delay(SPLASH_TIME_OUT)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }

//        handler.postDelayed({
// Navigate to MainActivity after the delay
//            val intent = Intent(this@SplashActivity, MainActivity::class.java)
//            startActivity(intent)
//            finish() },
//            SPLASH_TIME_OUT)
    }

//    override fun onStart() {
//        super.onStart()
//        Log.d(TAG, "onStart: SplashActivity started.")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d(TAG, "onResume: SplashActivity resumed.")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d(TAG, "onPause: SplashActivity paused.")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d(TAG, "onStop: SplashActivity stopped.")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.d(TAG, "onRestart: SplashActivity restarted.")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d(TAG, "onDestroy: SplashActivity destroyed.")
//    }
}
