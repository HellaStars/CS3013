package com.example.colorfragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ChoiceFragment : Fragment() {
    // Reference to the activity implementing the listener
    private var choiceListener: MainActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {
            choiceListener = context
        } else {
            throw RuntimeException("$context must implement ChoiceListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the TextViews
        val textRed = view.findViewById<TextView>(R.id.textRed)
        val textBlue = view.findViewById<TextView>(R.id.textBlue)

        // Set click listeners
        textBlue.setOnClickListener {
            choiceListener?.onSelected(1) // 1 for blue
        }

        textRed.setOnClickListener {
            choiceListener?.onSelected(2) // 2 for red
        }
    }

    override fun onDetach() {
        super.onDetach()
        choiceListener = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = ChoiceFragment()
    }
}
