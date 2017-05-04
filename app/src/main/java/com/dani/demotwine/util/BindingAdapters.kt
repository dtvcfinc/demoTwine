package com.dani.demotwine.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by dani on 4/05/17.
 */
@BindingAdapter("bind:imageUrl")
fun ImageView.loadImage(url: String?) {
    url?.let {
        Picasso.with(context)
                .load(url)
                .transform(CircleTransform())
                .into(this)
    }
}

