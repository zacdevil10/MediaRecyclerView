package uk.co.zac_h.mediarecyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import uk.co.zac_h.mediarecyclerview.R
import uk.co.zac_h.mediarecyclerview.databinding.PhotoViewZoomableBinding
import uk.co.zac_h.mediarecyclerview.models.MediaModel
import uk.co.zac_h.mediarecyclerview.utils.MediaType
import uk.co.zac_h.mediarecyclerview.utils.errorFromRes

class PhotoViewPagerAdapter(
    private val context: Context,
    private val media: ArrayList<MediaModel>
) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any =
        with(PhotoViewZoomableBinding.inflate(LayoutInflater.from(context))) {
            when (type[position]) {
                MediaType.IMAGE_URL -> Glide.with(context).load(getImageUrlAt(position))
                    .errorFromRes(context, R.drawable.ic_baseline_error_outline_24)
                    .into(zoomableImageView)
                MediaType.IMAGE_RES -> zoomableImageView.setImageResource(getImageResAt(position))
                else -> throw IllegalArgumentException("Invalid resource type: $type")
            }

            container.addView(root)

            root
        }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean = `object` == view

    override fun getCount(): Int = media.size

    private fun getImageUrlAt(position: Int): String = media[position].url as String

    private fun getImageResAt(position: Int): Int =
        media[position].res ?: R.drawable.ic_baseline_error_outline_24

    companion object Builder {
        lateinit var type: List<MediaType>

        fun setImageType(mediaType: List<MediaType>): Builder {
            type = mediaType
            return this
        }

        fun build(context: Context, media: ArrayList<MediaModel>): PagerAdapter =
            PhotoViewPagerAdapter(context, media)
    }

}