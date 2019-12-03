package uk.co.zac_h.mediarecyclerview.ui

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import uk.co.zac_h.mediarecyclerview.adapters.MediaRecyclerAdapter
import uk.co.zac_h.mediarecyclerview.models.MediaModel
import kotlin.math.min

class MediaRecyclerView : RecyclerView {

    private var height: Int? = null
    private var margin: Int? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    fun configure(context: Context?, media: ArrayList<MediaModel>) {
        layoutManager =
            StaggeredGridLayoutManager(min(media.size, 2), StaggeredGridLayoutManager.VERTICAL)
        adapter =
            MediaRecyclerAdapter.setMedia(media).setHeight(height).setMargin(margin).build(context)
    }

    fun height(height: Int) {
        this.height = height
    }

    fun setMargin(margin: Int) {
        this.margin = margin
    }

}