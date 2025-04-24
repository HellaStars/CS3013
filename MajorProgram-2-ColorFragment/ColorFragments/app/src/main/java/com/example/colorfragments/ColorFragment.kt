package com.example.colorfragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ColorFragment : Fragment() {
    // Static counter for fragment instances
    companion object {
        private var fragmentCount = 0

        @JvmStatic
        fun newInstance(choice: Int) = ColorFragment().apply {
            arguments = Bundle().apply {
                putInt("COLOR CHOICE", choice)
            }
        }
    }

    // Instance-specific index
    private var myIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Only increment counter and set index if this is first creation
        if (savedInstanceState == null) {
            fragmentCount++
            myIndex = fragmentCount
        } else {
            // Restore the saved index if fragment is being recreated
            myIndex = savedInstanceState.getInt("MY_INDEX")
            // Update fragment count if necessary
            if (myIndex > fragmentCount) {
                fragmentCount = myIndex
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the TextView reference
        val chosenColorTV = view.findViewById<TextView>(R.id.fragText)

        // Get the color choice (1 for blue, 2 for red)
        val choiceId = arguments?.getInt("COLOR CHOICE", 0) ?: 0

        when (choiceId) {
            1 -> { // Blue
                chosenColorTV.text = "GENERIC BLUE FRAGMENT - UID $myIndex"
                chosenColorTV.setBackgroundColor(Color.rgb(150, 150, 255))
            }
            2 -> { // Red
                chosenColorTV.text = "GENERIC RED FRAGMENT - UID $myIndex"
                chosenColorTV.setBackgroundColor(Color.rgb(255, 150, 150))
            }
        }
    }
}
