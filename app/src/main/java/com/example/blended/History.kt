package com.example.blended

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.blended.Lists.CalorieMainList

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
                 Toast.makeText(this@History,"left is clicked",Toast.LENGTH_LONG).show()
                val intent = Intent(this@History, History1::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
            }

            override fun onSwipeRight() {
                super.onSwipeRight()
                Toast.makeText(this@History,"right is clicked", Toast.LENGTH_LONG).show()
                val intent = Intent(this@History, History2::class.java)
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
                val intent = Intent(this@History, HomeInfo::class.java)
                startActivity(intent)
            }

            R.id.tube -> {
                val intent = Intent(this@History, TubeCareMainFragment::class.java)
                startActivity(intent)
            }
            R.id.calories -> {
                val intent = Intent(this@History, CalorieMainList::class.java)
                startActivity(intent)
            }
            R.id.special -> {
                val intent = Intent(this@History, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.history -> {
                val intent = Intent(this@History, History::class.java)
                startActivity(intent)
            }
            R.id.contact -> {
                val intent = Intent(this@History, ContactUs::class.java)
                startActivity(intent)

            }

        }
        return super.onOptionsItemSelected(item)
    }




}


