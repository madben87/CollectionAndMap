package com.kvadgroup.collectionandmap.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView

class TabCell @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    private var text: TextView = TextView(context)
    private var progress: ProgressBar = ProgressBar(context)

    init {
        val param: FrameLayout.LayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        param.gravity = Gravity.CENTER
        this.addView(text, param)
        this.addView(progress, param)
        text.visibility = View.VISIBLE
        progress.visibility = View.GONE
    }

    fun showProgress() {
        progress.visibility = View.VISIBLE
        text.visibility = View.GONE
    }

    fun hideProgress() {
        progress.visibility = View.GONE
        text.visibility = View.VISIBLE
    }

    fun setText(msg: String) {
        progress.visibility = View.GONE
        text.visibility = View.VISIBLE
        text.setText(msg)
    }
}