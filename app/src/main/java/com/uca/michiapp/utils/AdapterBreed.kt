package com.uca.michiapp.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
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
        holder.breedname.text = model.name
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val breedname: TextView = view.breedName
    }

}