package com.dakotakim.hellouniverse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.dakotakim.hellouniverse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        // Setup a Binding Object
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        // Lambda syntax
        binding.greetButton.setOnClickListener { btn ->
            binding.greetingText.text = "Hello, ${binding.personButton.text}"
        }


        // To-Read: Synthetic Properties
        binding.goodbyeButton.setOnClickListener { btn ->
            binding.greetingText.text = "Goodbye, ${binding.personButton.text}"
        }
    }
}

class HelloWorldViewModel: ViewModel() {
    
}
