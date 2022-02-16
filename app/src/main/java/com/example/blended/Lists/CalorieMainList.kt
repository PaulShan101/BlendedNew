package com.example.blended.Lists

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.example.blended.*
import kotlinx.android.synthetic.main.activity_listview.*


class CalorieMainList : AppCompatActivity() {


    //this array will be printed out in the list view
    val calories = arrayOf<String>(
            "Banana (1)  27 GRAMS",
            "Orange (1)  16 GRAMS",
            "Apple  (1)  21 GRAMS",
            "Soup   (1)  25 GRAMS",
            "Grapes (1 Cup) 28 GRAMS"


    )


    //will be beside the first array
    val description = arrayOf<String>(
            "105 CALORIES",
            "65 CALORIES",
            "81 CALORIES",
            "100 CALORIES",
            "114 CALORIES"


    )

    //an array of images for the list view
    val imageId = arrayOf<Int>(
            R.drawable.banana, R.drawable.orange1, R.drawable.apple,R.drawable.soup,R.drawable.grapes


            )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)


        val myListAdapter = ListViewAdapter(this, calories, description, imageId)

        listView.adapter = myListAdapter













        listView.setOnItemClickListener() { adapterView, view, position, id ->


            //if statement for when the position is clicked the https appears
            if (position == 0) {
                //val intent = Intent(this@MainWorldCup, MainQuizPage::class.java)
                // startActivity(intent)
                val i = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://en.wikipedia.org/wiki/Tipperary_GAA")
                )
                startActivity(i)

            }
            if (position == 1) {
                val i = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://en.wikipedia.org/wiki/Cork_GAA")
                )
                startActivity(i)

            }
            if (position == 2) {
                val i = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://en.wikipedia.org/wiki/Kerry_GAA")
                )
                startActivity(i)

            }

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
                val intent = Intent(this@CalorieMainList, HomeInfo::class.java)
                startActivity(intent)
            }

            R.id.tube -> {
                val intent = Intent(this@CalorieMainList, TubeCareMainFragment::class.java)
                startActivity(intent)
            }
            R.id.calories -> {
                val intent = Intent(this@CalorieMainList, CalorieMainList::class.java)
                startActivity(intent)
            }
            R.id.special -> {
                val intent = Intent(this@CalorieMainList, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.history -> {
                val intent = Intent(this@CalorieMainList, History::class.java)
                startActivity(intent)
            }
            R.id.contact -> {
                val intent = Intent(this@CalorieMainList, ContactUs::class.java)
                startActivity(intent)

            }

        }
        return super.onOptionsItemSelected(item)
    }




}

