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
import androidx.fragment.app.Fragment
import com.wit.blended.TubeCare2


import kotlinx.android.synthetic.main.activity_tubecare_fragment.*

class TubeCareMainFragment : AppCompatActivity() {

     //main fragment page that attaches to the rest of the fragments
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_tubecare_fragment)
        //controls all the fragments for the tube care sec
        val tubeCare1 = TubeCare1()
        val tubeCare2 = TubeCare2()
        val tubeCare3 = TubeCare3()
        val tubeCare4 = TubeCare4()


        makeCurrentFragment(tubeCare1)
        //bottom buttons for each section
        button_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.t1 -> makeCurrentFragment(tubeCare1)
                R.id.t2 -> makeCurrentFragment(tubeCare2)
                R.id.t3 -> makeCurrentFragment(tubeCare3)
                R.id.t4 -> makeCurrentFragment(tubeCare4)

            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, fragment)
                commit()
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
                val intent = Intent(this@TubeCareMainFragment, HomeInfo::class.java)
                startActivity(intent)
            }

            R.id.tube -> {
                val intent = Intent(this@TubeCareMainFragment, TubeCareMainFragment::class.java)
                startActivity(intent)
            }
            R.id.calories -> {
                val intent = Intent(this@TubeCareMainFragment, CalorieMainList::class.java)
                startActivity(intent)
            }
            R.id.special -> {
                val intent = Intent(this@TubeCareMainFragment, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.history -> {
                val intent = Intent(this@TubeCareMainFragment, Tips::class.java)
                startActivity(intent)
            }
            R.id.contact -> {
                val intent = Intent(this@TubeCareMainFragment, ContactUs::class.java)
                startActivity(intent)

            }

        }
        return super.onOptionsItemSelected(item)
    }




}


