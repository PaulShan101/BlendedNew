package com.example.blended
/*AUTHOR: Paul Shanahan
Date : 10/02/2022
Version : 1.0
*/
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blended.*
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

//firebase main page
class MainActivity : AppCompatActivity() {
    lateinit var mDataBase:DatabaseReference
    private lateinit var dietList:ArrayList<DietData>
    private lateinit var mAdapter: DietAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**initialized*/
        dietList = ArrayList()
        mAdapter = DietAdapter(this, dietList)
        recyclerDiet.layoutManager = LinearLayoutManager(this)
        recyclerDiet.setHasFixedSize(true)

        getDietData()
//        mDataBase = FirebaseDatabase.getInstance().getReference("Diets").orderByChild("name") as DatabaseReference
    }
    //new commit test
    /**ok now create new activity*/

    //getting the data off the firebase console
    private fun getDietData() {

        mDataBase = FirebaseDatabase.getInstance().getReference("Diets")
        mDataBase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (dietSnapshot in snapshot.children) {
                        val diet = dietSnapshot.getValue(DietData::class.java)
                        dietList.add(diet!!)
                    }
                    recyclerDiet.adapter = mAdapter
                }
            }




            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,
                        error.message, Toast.LENGTH_SHORT).show()
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
                val intent = Intent(this@MainActivity, HomeInfo::class.java)
                startActivity(intent)
            }

            R.id.tube -> {
                val intent = Intent(this@MainActivity, TubeCareMainFragment::class.java)
                startActivity(intent)
            }
            R.id.calories -> {
                val intent = Intent(this@MainActivity, CalorieMainList::class.java)
                startActivity(intent)
            }
            R.id.special -> {
                val intent = Intent(this@MainActivity, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.history -> {
                val intent = Intent(this@MainActivity, Tips::class.java)
                startActivity(intent)
            }
            R.id.contact -> {
                val intent = Intent(this@MainActivity, ContactUs::class.java)
                startActivity(intent)

            }

        }
        return super.onOptionsItemSelected(item)
    }




}