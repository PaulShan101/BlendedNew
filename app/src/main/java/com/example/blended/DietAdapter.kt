package com.example.blended

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.blended.databinding.ItemListBinding


class DietAdapter(
    var c:Context,var dietList:ArrayList<DietData>
):RecyclerView.Adapter<DietAdapter.DietViewHolder>()
{
    inner class DietViewHolder(var v: ItemListBinding): RecyclerView.ViewHolder(v.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DietViewHolder {
        val inflter = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<ItemListBinding>(
            inflter, R.layout.item_list,parent,
            false)
        return DietViewHolder(v)

    }

    override fun onBindViewHolder(holder: DietViewHolder, position: Int) {
        val newList = dietList[position]
        holder.v.isAnimals = dietList[position]
        holder.v.root.setOnClickListener {
            val img = newList.img
            val name = newList.name
            val info = newList.info

            /**set Data*/
            val mIntent = Intent(c,New::class.java)
            mIntent.putExtra("img",img)
            mIntent.putExtra("name",name)
            mIntent.putExtra("info",info)
            c.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
        return  dietList.size
    }



}