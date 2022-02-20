package co.android.wframadhan.techtest.utils

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import co.android.wframadhan.techtest.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import java.io.IOException

class ApiException(message: String) : IOException(message)

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { t -> action(t) } })
}

fun ImageView.loadImageRectangle(url: String) =
    Glide.with(this)
        .setDefaultRequestOptions(
            RequestOptions()
                .placeholder(R.drawable.bg_fill_grey_transparent_rectangle_ripple)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        )
        .load(url)
        .into(this)
