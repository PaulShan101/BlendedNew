package com.example.blended

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_new.*

class New : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        /**get Data*/
        val dietIntent = intent
        val dietName = dietIntent.getStringExtra("name")
        val dietInfo = dietIntent.getStringExtra("info")
        val dietImg = dietIntent.getStringExtra("img")

        /**call text and images*/
        name.text = dietName
        info.text = dietInfo
        img.loadImage(dietImg, getProgessDrawable(this))
    }
    /**ok now run it */
}