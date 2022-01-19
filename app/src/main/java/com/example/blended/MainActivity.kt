package com.example.blended

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mDataBase:DatabaseReference
    private lateinit var dietList:ArrayList<DietData>
    private lateinit var mAdapter:DietAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**initialized*/
        dietList = ArrayList()
        mAdapter = DietAdapter(this,dietList)
        recyclerDiet.layoutManager = LinearLayoutManager(this)
        recyclerDiet.setHasFixedSize(true)
        // recyclerAnimals.adapter = mAdapter
        /**getData firebase*/
        getDietData()

    }
    /**ok now create new activity*/


    private fun getDietData() {

        mDataBase = FirebaseDatabase.getInstance().getReference("Diets")
        mDataBase.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (dietSnapshot in snapshot.children){
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




}