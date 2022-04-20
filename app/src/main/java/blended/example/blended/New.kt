package com.example.blended
/*AUTHOR: Paul Shanahan
Date : 10/02/2022
Version : 1.0
*/
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.blended.R
import com.example.blended.getProgessDrawable
import com.example.blended.loadImage

import kotlinx.android.synthetic.main.activity_new.*
//firebase strings and adding to the new layout off what was clicked in the main area
class New : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        /**get Data*/
        val dietIntent = intent
        val dietName = dietIntent.getStringExtra("name")
        val dietInfo = dietIntent.getStringExtra("info")
        val dietImg = dietIntent.getStringExtra("img")
        val dietDate = dietIntent.getStringExtra("date")
        val dietCalories = dietIntent.getStringExtra("calories")

        /**call text and images*/
        name.text = dietName
        info.text = dietInfo
        date.text = dietDate
        calories.text = dietCalories
        img.loadImage(dietImg, getProgessDrawable(this))
    }
    /**ok now run it */
}