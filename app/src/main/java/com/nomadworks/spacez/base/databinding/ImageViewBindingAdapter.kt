package com.nomadworks.spacez.base.databinding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import java.io.File

object ImageViewBindingAdapter {
    @JvmStatic
    @BindingAdapter("loadUrl")
    fun imageViewLoadUrl(imageView: ImageView, url: String?) {
        url?.run {
            imageView.load(this)
            imageView.visibility = View.VISIBLE
        } ?: run {
            imageView.visibility = View.INVISIBLE
        }
    }

    @JvmStatic
    @BindingAdapter("loadResource")
    fun imageViewLoadResource(imageView: ImageView, resourceId: Int) {
        imageView.load(resourceId)
    }

    @JvmStatic
    @BindingAdapter("loadFile")
    fun imageViewLoadFile(imageView: ImageView, path: String) {
        imageView.load(File(path))
    }
}