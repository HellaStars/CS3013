package com.example.getpassengers

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GetPassengers : AppCompatActivity() {

    private lateinit var FirstName: EditText
    private lateinit var LastName: EditText
    private lateinit var PhoneNumber: EditText
    private lateinit var PassengerList: TextView
    private lateinit var buttonAddPassenger: Button
    private lateinit var buttonSubmitList: Button

    private val passList = mutableListOf<Passenger>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Initialize views
        FirstName = findViewById(R.id.first_name)
        LastName = findViewById(R.id.last_name)
        PhoneNumber = findViewById(R.id.phone_number)
        PassengerList = findViewById(R.id.accum_list)
        buttonAddPassenger = findViewById(R.id.add_button)
        buttonSubmitList = findViewById(R.id.back_to_main)

        // Add passenger to the list
        buttonAddPassenger.setOnClickListener {
            val first = FirstName.text.toString()
            val last = LastName.text.toString()
            val phone = PhoneNumber.text.toString()

            if (first.isNotEmpty() && last.isNotEmpty() && phone.isNotEmpty()) {
                val newPassenger = Passenger(first, last, phone)
                passList.add(newPassenger)

                // Add the passenger details after the last line of the TextView
                PassengerList.append("\n" + newPassenger.toString())

                // Clear the input fields
                FirstName.text.clear()
                LastName.text.clear()
                PhoneNumber.text.clear()
            }
        }

        // Submit the final list back to MainActivity
        buttonSubmitList.setOnClickListener {
            val finalIntent = Intent()
            finalIntent.putExtra("COUNT", passList.size.toString()) // Add count

            // Add each passenger with keys like "PASS1", "PASS2", ...
            passList.forEachIndexed { index, passenger ->
                finalIntent.putExtra("PASS${index + 1}", passenger.toString())
            }

            setResult(RESULT_OK, finalIntent)
            finish() // Close the second activity
        }
    }
}
