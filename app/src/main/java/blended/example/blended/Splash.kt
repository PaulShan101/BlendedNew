package com.example.blended
/*AUTHOR: Paul Shanahan
Date : 10/02/2022
Version : 1.0
*/
import android.content.Intent

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


//opening page before the main screen shows in the app
class Splash : AppCompatActivity() {
    internal val TIME_OUT = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        getSupportActionBar()?.hide()
        Handler().postDelayed(
                {
                    startActivity(Intent(this@Splash, HomePage::class.java))
                    finish()
                }, TIME_OUT.toLong())
    }

}