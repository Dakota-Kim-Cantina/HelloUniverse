package com.dakotakim.hellouniverse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val greetingText = findViewById<TextView>(R.id.greeting_text)
        val personButton = findViewById<EditText>(R.id.person_button)
        val actionGreet = findViewById<Button>(R.id.action_greet)
        val actionGoodbye = findViewById<Button>(R.id.action_goodbye)

        // Lambda syntax
        actionGreet.setOnClickListener { btn ->
            greetingText.text = "Hello, ${personButton.text}"
        }

        actionGoodbye.setOnClickListener { btn ->
            greetingText.text = "Goodbye, ${personButton.text}"
        }
    }
}
