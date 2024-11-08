package com.tasty.recipesapp.activity

import android.os.Bundle
import android.os.HandlerThread
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tasty.recipesapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("SplashActivity", "SplashActivity - onCreate() called!")
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Use a HandlerThread to create a background thread
        val handlerThread = HandlerThread(HANDLER_THREAD_NAME, HANDLER_THREAD_PRIORITY)
        handlerThread.start()

        val handler = Handler(handlerThread.looper)
        handler.postDelayed(
            {

                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, SPLASH_SCREEN_TIMEOUT
        )

    }

    override fun onStart() {
        super.onStart()
//        Log.d(TAG, "onStart: SplashActivity started.")
    }

    override fun onResume() {
        super.onResume()
//        Log.d(TAG, "onResume: SplashActivity resumed.")
    }
}