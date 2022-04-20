package com.example.blended
/*AUTHOR: Paul Shanahan
Date : 10/02/2022
Version : 1.0
*/
import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity






import kotlinx.android.synthetic.main.activity_tips.*

class Tips1 : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips1)


        //code for the swiper functions and relgenerate is the area the user can swipe
        relGenerate.setOnTouchListener(object : OnSwipeTouchListener(this@Tips1) {



            override fun onSwipeLeft() {
                super.onSwipeLeft()
               // Toast.makeText(this@History1,"left is clicked", Toast.LENGTH_LONG).show()
                val intent= Intent(this@Tips1, Tips::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
            }

            override fun onSwipeRight() {
                super.onSwipeRight()
                //Toast.makeText(this@History1,"right is clicked", Toast.LENGTH_LONG).show()
                val intent= Intent(this@Tips1, Tips::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)

                //Toast.makeText(this@History1,"Left is clicked", Toast.LENGTH_LONG).show()
                //  Toast.makeText(this@MainActivity,"right is clicked",Toast.LENGTH_LONG).show()
            }
        })





    }
}