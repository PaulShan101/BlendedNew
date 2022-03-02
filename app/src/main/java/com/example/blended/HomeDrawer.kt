package com.example.blended

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.blended.Diary.DiaryActivity
import com.example.blended.Lists.CalorieMainList
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.homenav.*

class HomeDrawer : AppCompatActivity(),
        NavigationView.OnNavigationItemSelectedListener {

    lateinit var ft: FragmentTransaction


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homenav)


        getSupportActionBar()?.hide()

        navView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //navView.getHeaderView(0).nav_email_text.text = user_email?.text
        //
     ft = supportFragmentManager.beginTransaction()


//            navView.getHeaderView(0).nav_header_email.text =  user_email_text.text


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {


        when (item.itemId) {


            R.id.home -> {
                val intent = Intent(this@HomeDrawer, HomePage::class.java)
                startActivity(intent)
            }
            R.id.tubecare -> {
                val intent = Intent(this@HomeDrawer, TubeCareMainFragment::class.java)
                startActivity(intent)
            }


            R.id.calories1 -> {
                val intent = Intent(this@HomeDrawer, CalorieMainList::class.java)
                startActivity(intent)
            }

//            R.id.winners -> {
//                val intent = Intent(this@HomeDrawer, SpecialDiets::class.java)
//                startActivity(intent)
//            }
//
//            R.id.profile -> {
//                val intent = Intent(this@HomeDrawer, History::class.java)
//                startActivity(intent)
//            }
//            R.id.login_btn -> {
//                val intent = Intent(this@HomeDrawer, ContactUs::class.java)
//                startActivity(intent)
//            }
//            R.id.signup_btn -> {
//                val intent = Intent(this@HomeDrawer, BMIActivity::class.java)
//                startActivity(intent)
//            }
//            R.id.google -> {
//                val intent = Intent(this@HomeDrawer, DiaryActivity::class.java)
//                startActivity(intent)
//            }



        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }

    private fun navigateTo(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.home, fragment)
                .addToBackStack(null)
                .commit()
    }

}



