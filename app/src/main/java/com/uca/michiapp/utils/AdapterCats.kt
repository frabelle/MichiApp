package com.uca.michiapp.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.uca.michiapp.R
import com.uca.michiapp.model.Cat
import kotlinx.android.synthetic.main.item_cat.view.*

class AdapterCats  () : RecyclerView.Adapter<AdapterCats.ViewHolder>() {

    lateinit var items: ArrayList<Cat>

    override fun getItemCount(): Int {
        return if(::items.isInitialized){
            items.size
        }else{
            0
        }
    }

    fun setCats(items: List<Cat>){
        this.items = items as ArrayList<Cat>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false))

    // Binds each item in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model= items[position]
        //holder.sizeInfo.text="${model.width} x ${model.height}"
        Picasso.get()
            .load(model.url)
            .into( holder.catImage)
    }
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each picture to
        val catImage: ImageView = view.catpic
        //val sizeInfo: TextView = view.size_info
    }

}