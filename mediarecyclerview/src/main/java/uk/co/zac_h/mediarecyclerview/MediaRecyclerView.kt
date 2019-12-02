package uk.co.zac_h.mediarecyclerview

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlin.math.min

class MediaRecyclerView : RecyclerView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    fun configure(context: Context?, media: ArrayList<String>) {
        layoutManager = StaggeredGridLayoutManager(min(media.size, 2), StaggeredGridLayoutManager.VERTICAL)
        adapter = MediaRecyclerAdapter.setMedia(media).setHeight(196).build(context)
    }

}