package com.example.blended

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_homepage.*

class HomePage : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)



        // To hide the status bar.
        // window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        /*    act1.setOnClickListener {

            val intent = Intent(this@MainActivity, SecondConstraintSet::class.java)
            startActivity(intent)*/





        btn_home.setOnClickListener {


            val intent = Intent(this@HomePage, HomeInfo::class.java)

            startActivity(intent)


        }






        btn_tubecare.setOnClickListener {


            val intent = Intent(this@HomePage, TubeCare::class.java)

            startActivity(intent)


        }
        btn_special.setOnClickListener {

            val intent = Intent(this@HomePage, SpecialDiets::class.java)

            startActivity(intent)


        }
        btn_calories.setOnClickListener {


            val intent = Intent(this@HomePage, Calories::class.java)

            startActivity(intent)


        }
        btn_purchase.setOnClickListener {


            val intent = Intent(this@HomePage, MainActivity::class.java)

            startActivity(intent)


        }
        btn_history.setOnClickListener {


            val intent = Intent(this@HomePage, History::class.java)

            startActivity(intent)


        }


    }

//    //menu for the page
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.main, menu)
//        return true
//    }
//
//    //when u click on a menu item the next activity shows
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        when (item.itemId) {
//            R.id.home_1 -> {
//                val intent = Intent(this@MainQuizPage, StartPage::class.java)
//                startActivity(intent)
//            }
//
//            R.id.cl_1 -> {
//                val intent = Intent(this@MainQuizPage, MainActivity::class.java)
//                startActivity(intent)
//            }
//            R.id.pl_1 -> {
//                val intent = Intent(this@MainQuizPage, PremierLeagueSet1::class.java)
//                startActivity(intent)
//            }
//            R.id.wc_1 -> {
//                val intent = Intent(this@MainQuizPage, MainWorldCup::class.java)
//                startActivity(intent)
//            }
//            R.id.qz_1 -> {
//                val intent = Intent(this@MainQuizPage, MainQuizPage::class.java)
//                startActivity(intent)
//            }
//            R.id.onq_1 -> {
//                val intent = Intent(this@MainQuizPage, OnlineQuiz::class.java)
//                startActivity(intent)
//
//            }
//
//        }
//        return super.onOptionsItemSelected(item)
//    }




}



