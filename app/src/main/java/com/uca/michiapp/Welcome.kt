package com.uca.michiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        activateGIF()
    }

    fun activateGIF(){
        val imageView: ImageView = findViewById(R.id.michilogo)
        Glide.with(this).load(R.drawable.michi).into(imageView)
    }
}