package com.uca.michiapp.ui.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.squareup.picasso.Picasso
import com.uca.michiapp.R
import com.uca.michiapp.model.Breed
import kotlinx.android.synthetic.main.fragment_breed.view.*

class BreedFragment : DialogFragment() {

    var breedModel: Breed? = null

    fun getCatObject(breed: Breed) {
        breedModel = breed
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView: View = inflater.inflate(R.layout.fragment_breed, container, false)
        return rootView
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settingData(view)
    }

    private fun settingData(view: View) {

        //TESTING PASSING VALUES
        //Log.d("PASSING VALUES", breedModel?.name.toString())

        view.breed.setText(breedModel?.name)
        view.country.setText(breedModel?.origin)
        view.weight.setText(" " + breedModel?.weight?.metric.toString()+ " kilograms")
        view.lifespan.setText(" " + breedModel?.lifeSpan + " years")
        view.description.setText(breedModel?.description)

        Picasso.get()
                .load(breedModel?.image?.url)
                .into(view.catpic)

        view.btnDone.setOnClickListener({
            dismiss()
        })

        view.btnMoreinfo.setOnClickListener({
            sendingToWikipedia()
        })

    }

    private fun sendingToWikipedia() {
        val url = breedModel?.wikipediaURL
        if(url == null) return
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }


}