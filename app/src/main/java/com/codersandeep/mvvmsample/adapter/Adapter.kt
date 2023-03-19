package com.codersandeep.mvvmsample.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.codersandeep.mvvmsample.R
import com.squareup.picasso.Picasso

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String?) {
    if (url != null) {
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_error)
            .into(this)
    }
}