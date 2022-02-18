package com.example.blended

import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity



import kotlinx.android.synthetic.main.activity_history.*

class History2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history2)
        relGenerate.setOnTouchListener(object : OnSwipeTouchListener(this@History2) {

            override fun onSwipeTop() {
                super.onSwipeTop()
                Toast.makeText(this@History2, "Top is clicked", Toast.LENGTH_LONG).show()
            }

            override fun onSwipeBottom() {
                super.onSwipeBottom()
                //    Toast.makeText(this@MainActivity,"Bottom is clicked",Toast.LENGTH_LONG).show()
            }

            override fun onSwipeLeft() {
                super.onSwipeLeft()
                Toast.makeText(this@History2, "left is clicked", Toast.LENGTH_LONG).show()
                val intent = Intent(this@History2, History1::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
            }

            override fun onSwipeRight() {
                super.onSwipeRight()
                Toast.makeText(this@History2, "right is clicked", Toast.LENGTH_LONG).show()
                val intent = Intent(this@History2, History::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
            }
        })



    }
}
