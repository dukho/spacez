package com.nomadworks.spacez.common.base.databinding

import android.view.View
import androidx.databinding.BindingAdapter

object ViewBindingAdapter {
    @JvmStatic
    @BindingAdapter("visibleOrGone")
    fun viewVisibleOrGone(view: View, visible: Boolean) {
        if (visible) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    @JvmStatic
    @BindingAdapter("visibleOrInvisible")
    fun viewVisibleOrInvisible(view: View, visible: Boolean) {
        if (visible) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.INVISIBLE
        }
    }
}