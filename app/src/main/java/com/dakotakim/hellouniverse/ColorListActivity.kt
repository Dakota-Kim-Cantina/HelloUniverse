package com.dakotakim.hellouniverse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.dakotakim.hellouniverse.databinding.ActivityColorListBinding

class ColorListActivity : AppCompatActivity() {

    private val colorsAdapter = ColorsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityColorListBinding>(
                this,
                R.layout.activity_color_list
            )
        binding.colorsList.layoutManager = LinearLayoutManager(this)
        binding.colorsList.adapter = colorsAdapter


        // Map color into views that can be placed into the recycler view.
        // With a RecyclerViewAdapter. (Does what it says on the tin).

        val colorViewModel = ViewModelProviders.of(this).get(ColorViewModel::class.java)

        colorViewModel.colors.observe(this, Observer {
            colorsAdapter.data = it
        })
    }
}

class ColorViewModel : ViewModel() {

    // expressions - no side effects
    // statements - side effects

    // Kotlin > Java - Kt allows use of expressions where J would only allow statements.

    // to-read: autoboxing?

    // LiveData list of colors
    val colors: LiveData<List<RainbowColor>> = MutableLiveData<List<RainbowColor>>().apply {
        value = RainbowColor.values().toList()
    }
}