package com.dakotakim.hellouniverse

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class ColorView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var viewModel: ColorViewViewModel? = null
        set(value) {
            value?.let {
                field = value
                setBackgroundColor(mapRainbowColorToAndroidColor(it.color))
            }
        }

    private fun mapRainbowColorToAndroidColor(color: RainbowColor): Int {
        return when (color) {
            RainbowColor.RED -> ContextCompat.getColor(context, R.color.red)
            RainbowColor.ORANGE -> ContextCompat.getColor(context, R.color.orange)
            RainbowColor.YELLOW -> ContextCompat.getColor(context, R.color.yellow)
            RainbowColor.GREEN -> ContextCompat.getColor(context, R.color.green)
            RainbowColor.BLUE -> ContextCompat.getColor(context, R.color.blue)
            RainbowColor.INDIGO -> ContextCompat.getColor(context, R.color.indigo)
            RainbowColor.VIOLET -> ContextCompat.getColor(context, R.color.violet)
        }
    }

    init {
        minimumHeight = resources.getDimensionPixelSize(R.dimen.colorHeight)

    }
}

data class ColorViewViewModel(val color: RainbowColor)