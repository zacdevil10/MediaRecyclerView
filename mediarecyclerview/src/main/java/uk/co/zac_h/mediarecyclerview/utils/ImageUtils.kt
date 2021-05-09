package uk.co.zac_h.mediarecyclerview.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.bumptech.glide.RequestBuilder

fun RequestBuilder<Drawable>.errorFromRes(context: Context, resource: Int) =
    this.error(ContextCompat.getDrawable(context, resource))

fun ConstraintSet.setup(container: ConstraintLayout, imageView: ImageView, ratio: String) {
    clone(container)
    setDimensionRatio(imageView.id, ratio)
    applyTo(container)
}