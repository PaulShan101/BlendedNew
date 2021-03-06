package com.example.blended
/*AUTHOR: Paul Shanahan
Date : 10/02/2022
Version : 1.0
*/
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


import com.wit.blended.*


import kotlinx.android.synthetic.main.activity_listview.*


class CalorieMainList : AppCompatActivity() {


    //this array will be printed out in the list view
    val title = arrayOf<String>(
            "Banana (1)  27 GRAMS",
            "Orange (1)  16 GRAMS",
            "Apple  (1)  21 GRAMS",
            "Grapes (1 Cup) 28 GRAMS",
            "Blueberries (1 cup) 148 GRAMS",
            "KIwi (1) 183 GRAMS",
            "Pear (1) 178 GRAMS",
            "Strawberry (1) 152 GRAMS"



    )


    //will be beside the first array
    val description = arrayOf<String>(
            "105 CALORIES",
            "65 CALORIES",
            "81 CALORIES",
            "114 CALORIES",
             "84 CALORIES",
            "112 CALORIES",
            "101 CALORIES",
            "49 CALORIES"



    )

    //an array of images for the list view
    val imageId = arrayOf<Int>(
            R.drawable.bananas, R.drawable.orange, R.drawable.apple,R.drawable.grape,R.drawable.blueberries,R.drawable.kiwi,R.drawable.pear,R.drawable.strawberry1


            )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

       // var viewSearch = MenuItemCompat.getActionView(menuItem) as SearchView


        val myListAdapter = ListViewAdapter(this, title, description, imageId)

        listView.adapter = myListAdapter

        val search = findViewById<SearchView>(R.id.searchView) as SearchView

        search.setOnQueryTextListener(object:SearchView.OnQueryTextListener  {

            override fun onQueryTextSubmit(query: String?): Boolean {

                 if(description.contains(query)) {
                     myListAdapter.filter.filter(query)
                 } else {
                     Toast.makeText(this@CalorieMainList, "No Match found", Toast.LENGTH_LONG).show()
                 }
                 return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
//                myListAdapter.filter.filter(newText)
//                calories.contains(newText.toString())
                return false

            }
        }

        )











        listView.setOnItemClickListener() { adapterView, view, position, id ->




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
                val intent = Intent(this@CalorieMainList, Tips::class.java)
                startActivity(intent)
            }
            R.id.contact -> {
                val intent = Intent(this@CalorieMainList, ContactUs::class.java)
                startActivity(intent)

            }
            R.id.bmi1 -> {
                val intent = Intent(this@CalorieMainList, BMIActivity::class.java)
                startActivity(intent)

            }
            R.id.diary1 -> {
                val intent = Intent(this@CalorieMainList, DiaryActivity::class.java)
                startActivity(intent)

            }

        }
        return super.onOptionsItemSelected(item)
    }




}

