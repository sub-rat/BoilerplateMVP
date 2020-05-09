package com.subratgyawali.boilerplatemvp.utils

import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.webkit.URLUtil
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import com.bumptech.glide.Glide
import com.subratgyawali.boilerplatemvp.R
import java.io.File


@BindingAdapter("image")
fun loadImage(imageView: ImageView, @DrawableRes imageId: Int) {
//    if (URLUtil.isHttpsUrl(path) || URLUtil.isHttpUrl(path)) {
//        Glide.with(imageView.context).load(path).into(imageView)
//        return
//    }
    Glide.with(imageView.context)
        .load(imageId)
        .into(imageView)
}

@BindingAdapter("image_url")
fun loadImageUrl(imageView: ImageView, path: String) {
    if (URLUtil.isHttpsUrl(path) || URLUtil.isHttpUrl(path)) {
        Glide.with(imageView.context).load(path).fallback(R.drawable.profile_avatar).into(imageView)
        return
    }
}

fun loadBitmapImage(imageView: ImageView, location: String) {
    val uri = Uri.fromFile(File(location))
    Glide.with(imageView.context)
        .asBitmap()
        .load(uri)
        .into(imageView)
}
@BindingConversion
fun convertColorToDrawable(color: Int) = ColorDrawable(color)
