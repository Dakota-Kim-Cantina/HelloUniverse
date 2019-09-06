package com.dakotakim.hellouniverse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.dakotakim.hellouniverse.databinding.ActivityColorListBinding

class ColorListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityColorListBinding>(this, R.layout.activity_color_list)
        binding.colorsList.layoutManager = LinearLayoutManager(this)
    }
}
