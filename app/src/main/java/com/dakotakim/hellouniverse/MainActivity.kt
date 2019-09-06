package com.dakotakim.hellouniverse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dakotakim.hellouniverse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        // ViewModels are classes. We /could/ just instantiate like any other class. However,
        // the context object is annoying to work with. Since context has lifecycle methods, it
        // can make working with state.
        // ViewModels extract state outside of the life cycle methods.
        // During config changes, activities are destroyed and they're recreated. The ViewModelProviders
        // keeps a log of ViewModels and instances to add a degree of separation between state and activity.
        // Maintaining across config changes.

        val viewModel = ViewModelProviders.of(this).get(HelloWorldViewModel::class.java)
        // Setup a Binding Object
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = viewModel
        viewModel.onColorNavigation.observe(this, Observer {
            startActivity(
                Intent(this, ColorListActivity::class.java)
            )
        })
    }
}

class HelloWorldViewModel : ViewModel() {
    val greetingText = ObservableField<String>("")
    val personName = ObservableField<String>("")

    // We will provide information to SingleLiveEvent
    // and it will emit to its observers.

    // Encapsulation -> separation of concerns
    private val navigationStream = SingleLiveEvent<Void>()
    val onColorNavigation : LiveData<Void> = navigationStream

    fun onGreetActionClicked() {
        greetingText.set("Hello, ${personName.get()}")
    }

    fun onGoodbyeActionClicked() {
        greetingText.set("Goodbye, ${personName.get()}")
    }

    fun onColorsActionClicked() {
        navigationStream.value = null
    }
}
