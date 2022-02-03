package com.example.blended

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_history.*


import kotlinx.android.synthetic.main.activity_main.*

class History : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)


        relGenerate.setOnTouchListener(object : OnSwipeTouchListener(this@History) {

            override fun onSwipeTop() {
                super.onSwipeTop()
                Toast.makeText(this@History, "Top is clicked", Toast.LENGTH_LONG).show()
            }

            override fun onSwipeBottom() {
                super.onSwipeBottom()
                //    Toast.makeText(this@MainActivity,"Bottom is clicked",Toast.LENGTH_LONG).show()
            }

            override fun onSwipeLeft() {
                super.onSwipeLeft()
                // Toast.makeText(this@HistoryMain,"right is clicked",Toast.LENGTH_LONG).show()
                val intent = Intent(this@History, History1::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
            }

            override fun onSwipeRight() {
                super.onSwipeRight()
                //  Toast.makeText(this@MainActivity,"right is clicked",Toast.LENGTH_LONG).show()
            }
        })

        relPrint.setOnTouchListener(object : OnSwipeTouchListener(this@History) {

            override fun onSwipeTop() {
                super.onSwipeTop()
                //    Toast.makeText(this@MainActivity,"Top is clicked",Toast.LENGTH_LONG).show()
            }

            override fun onSwipeBottom() {
                super.onSwipeBottom()
                //  Toast.makeText(this@MainActivity,"Bottom is clicked",Toast.LENGTH_LONG).show()
            }

            override fun onSwipeLeft() {
                super.onSwipeLeft()
                //   Toast.makeText(this@MainActivity,"Left is clicked",Toast.LENGTH_LONG).show()
            }

            override fun onSwipeRight() {
                super.onSwipeRight()

                val intent = Intent(this@History, History2::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)

                //Toast.makeText(this@HistoryMain,"left is clicked",Toast.LENGTH_LONG).show()
            }
        })


    }
}


