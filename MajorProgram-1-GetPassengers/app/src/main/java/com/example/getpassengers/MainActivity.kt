package com.example.getpassengers

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private var returnedString: String = "RETURNED PASSENGER LIST \n"

class MainActivity : AppCompatActivity() {

    private lateinit var topLabel: TextView
    private lateinit var getListButton: Button
    private lateinit var showList: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        topLabel = findViewById(R.id.top_label)
        getListButton = findViewById(R.id.get_list_button)
        showList = findViewById(R.id.show_list)

        // Set up button click listener to open the GetPassengers activity
        getListButton.setOnClickListener {
            val intent = Intent(this, GetPassengers::class.java)
            startActivityForResult(intent, 1) // Request code is 1
        }
    }

    // Handle the result from GetPassengers activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val count = data?.getStringExtra("COUNT")?.toIntOrNull() ?: 0
            val passengers = StringBuilder()

            // Add the heading "RETURNED PASSENGER LIST" at the top
            passengers.append("RETURNED PASSENGER LIST\n")

            for (i in 1..count) {
                val passenger = data?.getStringExtra("PASS$i") ?: ""
                passengers.append("$passenger\n")
            }

            // Display all passengers with the heading
            showList.text = passengers.toString().trim()
        }
    }
}

data class Passenger(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String
) {
    override fun toString(): String {
        return "$firstName $lastName Phone: $phoneNumber"
    }
}
