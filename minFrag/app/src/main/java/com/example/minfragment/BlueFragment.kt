package com.example.minfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

private const val ARG_PARAM1 = "param1"

class BlueFragment : Fragment() {
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) { //sets up the fragment to be seen by the user
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blue, container, false) //makes the fragment viewable

        return view
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            BlueFragment().apply {
                arguments = Bundle().apply { //bundles the args
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}