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


import kotlinx.android.synthetic.main.activity_homepage.*
import kotlinx.android.synthetic.main.button_layout.btn_tubecare
import kotlinx.android.synthetic.main.button_layout.btn_home
import kotlinx.android.synthetic.main.button_layout.btn_special
import kotlinx.android.synthetic.main.button_layout.btn_calories
import kotlinx.android.synthetic.main.button_layout.btn_history
import kotlinx.android.synthetic.main.button_layout.btn_purchase

import kotlinx.android.synthetic.main.button_layout.*

class HomePage : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.button_layout)

        



        btn_home.setOnClickListener {


            val intent = Intent(this@HomePage, HomeDrawer::class.java)

            startActivity(intent)


        }



        btn_tubecare.setOnClickListener {


            val intent = Intent(this@HomePage, TubeCareMainFragment::class.java)

            startActivity(intent)


        }
        btn_special.setOnClickListener {

            val intent = Intent(this@HomePage, MainActivity::class.java)

            startActivity(intent)


        }
        btn_calories.setOnClickListener {


            val intent = Intent(this@HomePage, CalorieMainList::class.java)

            startActivity(intent)


        }
        btn_purchase.setOnClickListener {


            val intent = Intent(this@HomePage, ContactUs::class.java)

            startActivity(intent)


        }
        btn_history.setOnClickListener {


            val intent = Intent(this@HomePage, Tips::class.java)

            startActivity(intent)


        }

        btn_bmi.setOnClickListener {


            val intent = Intent(this@HomePage, BMIActivity::class.java)

            startActivity(intent)


        }

        btn_diary.setOnClickListener {


            val intent = Intent(this@HomePage, DiaryActivity::class.java)

            startActivity(intent)


        }


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
                val intent = Intent(this@HomePage, HomeInfo::class.java)
                startActivity(intent)
            }

            R.id.tube -> {
                val intent = Intent(this@HomePage, TubeCareMainFragment::class.java)
                startActivity(intent)
            }
            R.id.calories -> {
                val intent = Intent(this@HomePage, CalorieMainList::class.java)
                startActivity(intent)
            }
            R.id.special -> {
                val intent = Intent(this@HomePage, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.history -> {
                val intent = Intent(this@HomePage, Tips::class.java)
                startActivity(intent)
            }
            R.id.contact -> {
                val intent = Intent(this@HomePage, ContactUs::class.java)
                startActivity(intent)

            }
            R.id.bmi1 -> {
                val intent = Intent(this@HomePage, BMIActivity::class.java)
                startActivity(intent)

            }
            R.id.diary1 -> {
                val intent = Intent(this@HomePage, DiaryActivity::class.java)
                startActivity(intent)

            }

        }
        return super.onOptionsItemSelected(item)
    }




}



