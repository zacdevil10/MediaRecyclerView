package uk.co.zac_h.mediarecyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import uk.co.zac_h.mediarecyclerview.R
import uk.co.zac_h.mediarecyclerview.models.MediaModel

class PhotoViewPagerAdapter(
    private val context: Context,
    private val media: ArrayList<MediaModel>?
) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view =
            LayoutInflater.from(context).inflate(R.layout.photo_view_zoomable, container, false)

        val imageView: ImageView = view.findViewById(R.id.zoomable_image_view)

        when (type) {
            1 -> Glide.with(context).load(getImageUrlAt(position)).into(imageView)
            2 -> imageView.setImageResource(getImageResourceAt(position))
            else -> throw IllegalArgumentException("Invalid resource type: $type")
        }

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean = `object` == view

    override fun getCount(): Int = media?.size ?: 0

    private fun getImageUrlAt(position: Int): String = media?.get(position)?.url as String

    private fun getImageResourceAt(position: Int): Int = media?.get(position) as Int

    companion object Builder {
        const val URL = 1
        const val RES = 2

        private var type: Int = 0

        fun setImageType(mediaType: Int): Builder {
            type = mediaType
            return this
        }

        fun build(context: Context, media: java.util.ArrayList<MediaModel>?): PagerAdapter =
            PhotoViewPagerAdapter(
                context,
                media
            )
    }

}