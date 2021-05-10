package com.uca.michiapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collect
import com.uca.michiapp.R
import com.uca.michiapp.intent.Intent
import com.uca.michiapp.model.Breed
import com.uca.michiapp.ui.MainActivity
import com.uca.michiapp.ui.MainApp
import com.uca.michiapp.ui.MainViewModel
import com.uca.michiapp.utils.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import java.text.FieldPosition
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment
constructor(
) : Fragment(R.layout.fragment_first) {

    private val TAG: String = "AppDebug"
    lateinit var rc: RecyclerView

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var breedAdapter: AdapterBreed

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()

        val layoutManager =
            LinearLayoutManager(
                requireActivity().applicationContext,
                LinearLayoutManager.VERTICAL,
                false
            )
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true
        recyclerViewCats.layoutManager = layoutManager
        recyclerViewCats.adapter = breedAdapter

        subscribeObservers()
        lifecycleScope.launch {
            viewModel.userIntent.send(Intent.GetCatEvent)
        }

        breedAdapter.setOnItemTapListener(object: ItemTapListener{
            override fun onItemTap(breed: Breed, position: Int) {

                //Testing
                //Toast.makeText(context, "Item $position clicked", Toast.LENGTH_SHORT).show()
                //Log.d("RecyclerView", "CLICK EN EL ONITEMTAP!"+ position)

                val dialog = BreedFragment()
                dialog.getCatObject(breed)
                activity?.let { dialog.show(it.supportFragmentManager, "DialogFragment") }
            }
        })
    }

    private fun subscribeObservers() {
        lifecycleScope.launch {
            viewModel.dataState.collect {
                when (it) {
                    is DataState.SuccessBreed -> {
                        displayProgressBar(false)
                        breedAdapter.setBreeds(it.breed)
                    }
                    is DataState.Error -> {
                        displayProgressBar(false)
                        displayError(it.exception.message)
                    }
                    is DataState.Loading -> {
                        displayProgressBar(true)
                    }
                }
            }
        }
    }

    private fun displayError(message: String?) {
        if (message != null) textDemo.text = message else textDemo.text = "Unknown error."
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        progress_bar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

}