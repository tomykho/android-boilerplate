package com.sample.application.widget

import android.content.Context
import android.widget.ImageView

/**
 * Created by tomykho on 5/19/17.
 */

class SquareImageView(context: Context) : ImageView(context) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = measuredWidth
        setMeasuredDimension(width, width)
    }

}