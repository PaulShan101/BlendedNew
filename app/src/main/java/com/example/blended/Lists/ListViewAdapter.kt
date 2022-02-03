package com.example.blended.Lists

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.blended.R


//list view adapter constructor for all the arrays and link to the listitem xml
class ListViewAdapter(private val context: Activity, private val title: Array<String>, private val description: Array<String>, private val imgid: Array<Int>)
    : ArrayAdapter<String>(context, R.layout.activity_calorieview, title) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.activity_calorieview, null, true)
        // THE 3 OPTIONS I HAVE IN THE LAYOUT 2 TEXTVIEWS AND AN IMAGE VIEW
        val titleText = rowView.findViewById(R.id.title) as TextView
        val imageView = rowView.findViewById(R.id.icon) as ImageView
        val subtitleText = rowView.findViewById(R.id.description) as TextView

        titleText.text = title[position]
        imageView.setImageResource(imgid[position])
        subtitleText.text = description[position]

        return rowView
    }
}