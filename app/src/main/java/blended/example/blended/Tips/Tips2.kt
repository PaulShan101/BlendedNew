package com.example.blended
/*AUTHOR: Paul Shanahan
Date : 10/02/2022
Version : 1.0
*/
import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity



import kotlinx.android.synthetic.main.activity_tips.*

class Tips2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips2)


        //code for the swiper functions and relgenerate is the area the user can swipe
        relGenerate.setOnTouchListener(object : OnSwipeTouchListener(this@Tips2) {



            override fun onSwipeLeft() {
                super.onSwipeLeft()
               // Toast.makeText(this@History2, "left is clicked", Toast.LENGTH_LONG).show()
                val intent = Intent(this@Tips2, Tips1::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
            }

            override fun onSwipeRight() {
                super.onSwipeRight()
               // Toast.makeText(this@History2, "right is clicked", Toast.LENGTH_LONG).show()
                val intent = Intent(this@Tips2, Tips::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
            }
        })



    }
}
