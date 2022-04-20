package com.example.blended
/*AUTHOR: Paul Shanahan
Date : 10/02/2022
Version : 1.0
*/
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

import com.example.blended.*
import com.wit.blended.*


import kotlinx.android.synthetic.main.activity_tips.*


import kotlinx.android.synthetic.main.activity_main.*

class Tips : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips)

       //code for the swiper functions and relgenerate is the area the user can swipe
        relGenerate.setOnTouchListener(object : OnSwipeTouchListener(this@Tips) {



            override fun onSwipeLeft() {
                super.onSwipeLeft()
                // Toast.makeText(this@History,"left is clicked",Toast.LENGTH_LONG).show()
                val intent = Intent(this@Tips, Tips1::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
            }

            override fun onSwipeRight() {
                super.onSwipeRight()
              //  Toast.makeText(this@History,"right is clicked", Toast.LENGTH_LONG).show()
                val intent = Intent(this@Tips, Tips2::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
            }
        })



    }

    //menu for the page
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }

    //when u click on a menu item the next activity shows
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.home -> {
                val intent = Intent(this@Tips, HomeInfo::class.java)
                startActivity(intent)
            }

            R.id.tube -> {
                val intent = Intent(this@Tips, TubeCareMainFragment::class.java)
                startActivity(intent)
            }
            R.id.calories -> {
                val intent = Intent(this@Tips, CalorieMainList::class.java)
                startActivity(intent)
            }
            R.id.special -> {
                val intent = Intent(this@Tips, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.history -> {
                val intent = Intent(this@Tips, Tips::class.java)
                startActivity(intent)
            }
            R.id.contact -> {
                val intent = Intent(this@Tips, ContactUs::class.java)
                startActivity(intent)

            }

        }
        return super.onOptionsItemSelected(item)
    }




}


