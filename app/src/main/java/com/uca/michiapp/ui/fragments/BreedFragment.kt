package com.uca.michiapp.ui.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.uca.michiapp.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BreedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BreedFragment : DialogFragment() {

    class PurchaseConfirmationDialogFragment : DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
                AlertDialog.Builder(requireContext())
                        .setMessage("Hi")
                        .setPositiveButton("OK") { _,_ -> }
                        .create()

        companion object {
            const val TAG = "PurchaseConfirmationDialog"
        }
    }
}