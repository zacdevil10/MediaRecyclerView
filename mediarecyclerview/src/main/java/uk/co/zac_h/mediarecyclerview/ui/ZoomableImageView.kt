package uk.co.zac_h.mediarecyclerview.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

class ZoomableImageView : ImageView {

    companion object {
        private const val NONE = 0
        private const val DRAG = 1
        private const val ZOOM = 2
        private const val CLICK = 3
    }

    constructor(context: Context) : super(context, null)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

}