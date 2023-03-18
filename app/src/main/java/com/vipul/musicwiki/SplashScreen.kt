package com.vipul.musicwiki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    private val SPLASH_SCREEN_TIME: Long = 2500
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.myLooper()!!).postDelayed({
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, SPLASH_SCREEN_TIME)
    }
}