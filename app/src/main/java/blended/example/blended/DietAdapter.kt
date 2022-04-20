package com.example.blended
/*AUTHOR: Paul Shanahan
Date : 10/02/2022
Version : 1.0
*/
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil


import androidx.recyclerview.widget.RecyclerView

import com.example.blended.R

import com.example.blended.databinding.ItemListBinding

//firebase diet adapter class
class DietAdapter(
    var c:Context,var dietList:ArrayList<DietData>
): RecyclerView.Adapter<DietAdapter.DietViewHolder>()
{
    inner class DietViewHolder(var v: ItemListBinding): RecyclerView.ViewHolder(v.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DietViewHolder {
        val inflter = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<ItemListBinding>(
            inflter, R.layout.item_list,parent,
            false)
        return DietViewHolder(v)

    }

    //holds all the variables in the firebase console. can add more as i go on
    override fun onBindViewHolder(holder: DietViewHolder, position: Int) {
        val newList = dietList[position]
        holder.v.isDiet = dietList[position]
        holder.v.root.setOnClickListener {
            val img = newList.img
            val name = newList.name
            val info = newList.info
            val date = newList.date
            val calories = newList.calories

            /**set Data*/
            val mIntent = Intent(c, New::class.java)
            mIntent.putExtra("img",img)
            mIntent.putExtra("name",name)
            mIntent.putExtra("info",info)
            mIntent.putExtra("date",date)
            mIntent.putExtra("calories",calories)
            c.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
        return  dietList.size
    }



}