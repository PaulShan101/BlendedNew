package com.example.blended

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_tubecare_fragment.*

class TubeCareMainFragment : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_tubecare_fragment)
        //controls all the fragments for the champions league sec
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






}

