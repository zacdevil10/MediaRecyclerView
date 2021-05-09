package uk.co.zac_h.mediarecyclerview.ui

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uk.co.zac_h.mediarecyclerview.adapters.MediaRecyclerAdapter
import uk.co.zac_h.mediarecyclerview.models.MediaModel
import kotlin.math.max
import kotlin.math.min

class MediaRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : RecyclerView(context, attrs, defStyle) {

    private var margin: Int? = null

    fun configure(context: Context, media: ArrayList<MediaModel>) {
        val mediaAdapter = MediaRecyclerAdapter.setMedia(media).setMargin(margin).build(context)
        layoutManager = GridLayoutManager(
            context,
            min(max(media.size, 1), 2),
            GridLayoutManager.VERTICAL,
            false
        ).apply {
            spanSizeLookup = mediaAdapter.spanSizeLookup
        }
        adapter = mediaAdapter
    }

    fun setMargin(margin: Int) {
        this.margin = margin
    }

}