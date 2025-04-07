package com.example.minfragment

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //makes the main activity viewable

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startFragment(view: View) {
        val framelayout = findViewById<FragmentContainerView>(R.id.fragment) //finds the fragment container
        val blueFragment = BlueFragment.newInstance("FIRST") //ints the fragment
        supportFragmentManager.beginTransaction().replace(framelayout.id, blueFragment).addToBackStack(null).commit() //replaces the container view with the blue fragment info
    }

}