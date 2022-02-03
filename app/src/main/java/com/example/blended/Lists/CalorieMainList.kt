package com.example.blended.Lists

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.example.blended.R
import kotlinx.android.synthetic.main.activity_listview.*


class CalorieMainList : AppCompatActivity() {


    //this array will be printed out in the list view
    val counties = arrayOf<String>(
            "Example1",
            "Example2",
            "Example3"


    )


    //will be beside the first array
    val description = arrayOf<String>(
            "LAST WINNERS - 2019",
            "LAST WINNERS - 2005",
            "LAST WINNERS - 2014"


    )

    //an array of images for the list view
    val imageId = arrayOf<Int>(
            R.drawable.cork, R.drawable.cork, R.drawable.cork,


            )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        val search = findViewById<SearchView>(R.id.searchView) as SearchView
        val myListAdapter = ListViewAdapter(this, counties, description, imageId)

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
}