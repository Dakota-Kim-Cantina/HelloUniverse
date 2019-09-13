package com.dakotakim.hellouniverse

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ColorsAdapter : RecyclerView.Adapter<ColorsAdapter.ColorViewHolder>() {

    var data: List<RainbowColor> = emptyList()

    class ColorViewHolder(itemView: ColorView) : RecyclerView.ViewHolder(itemView) {
        val colorView: ColorView
            get() = itemView as ColorView
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.colorView.viewModel = ColorViewViewModel(data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        // All sub classes of this will inherit the context of parent
        // (No passing context as constructor parameter)
        return ColorViewHolder(ColorView(parent.context))
    }
}
