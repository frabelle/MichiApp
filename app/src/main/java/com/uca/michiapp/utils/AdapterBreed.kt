package com.uca.michiapp.utils

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.squareup.picasso.Picasso
import com.uca.michiapp.R
import com.uca.michiapp.model.Breed
import kotlinx.android.synthetic.main.item_cat.view.*

class AdapterBreed() : RecyclerView.Adapter<AdapterBreed.ViewHolder>() {

    lateinit var items: ArrayList<Breed>

    override fun getItemCount(): Int {
        return if (::items.isInitialized){
            items.size
        }else{
            0
        }
    }

    fun setBreeds(items: List<Breed>){
        this.items = items as ArrayList<Breed>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model= items[position]
        val temp: List<String>
        holder.breedname.text = model.name
        holder.countryname.text = model.origin

        temp = model.temperament.split(", ")
        holder.temp1.text = temp[0]
        holder.temp2.text = temp[1]

        Picasso.get()
                .load(model.image?.url)
                .into( holder.catImage)

    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val breedname: TextView = view.breedName
        val catImage: ImageView = view.catpic
        val countryname: TextView = view.countryName
        val temp1: Chip = view.mood1
        val temp2: Chip = view.mood2
    }

}