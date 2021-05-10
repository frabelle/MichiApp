package com.uca.michiapp.utils

import android.view.View
import com.uca.michiapp.model.Breed

interface ItemTapListener {
    fun onItemTap(breed: Breed, position:Int)
}


