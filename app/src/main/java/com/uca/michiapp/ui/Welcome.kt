package com.uca.michiapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.uca.michiapp.R

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        activateGIF()

        val btnChange : MaterialButton = findViewById(R.id.btnStart)
        btnChange.setOnClickListener({
            startActivity()
        })
    }

    private fun startActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun activateGIF(){
        val imageView: ImageView = findViewById(R.id.michilogo)
        Glide.with(this).load(R.drawable.michi).into(imageView)
    }
}