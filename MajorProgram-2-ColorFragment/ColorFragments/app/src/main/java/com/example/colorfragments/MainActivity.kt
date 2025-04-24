package com.example.colorfragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), ChoiceListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            // Only create and add the fragment if this is the first time
            val cfv = findViewById<FragmentContainerView>(R.id.upperfragment_container)
            val choiceFragment = ChoiceFragment()
            supportFragmentManager.beginTransaction()
                .add(cfv.id, choiceFragment)
                .commit()
        }
    }

    override fun onSelected(choiceID: Int) {
        // Get reference to the lower fragment container
        val fcv = findViewById<FragmentContainerView>(R.id.lowerfragment_container)
        val colorFragment = ColorFragment.newInstance(choiceID)
        supportFragmentManager.beginTransaction()
            .replace(fcv.id, colorFragment)
            .addToBackStack(null)
            .commit()
    }
}

// Define the interface in the same file or a separate file
interface ChoiceListener {
    fun onSelected(id: Int)
}
