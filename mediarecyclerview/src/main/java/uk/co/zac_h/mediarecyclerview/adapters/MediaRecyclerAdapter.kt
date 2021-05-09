package uk.co.zac_h.mediarecyclerview.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uk.co.zac_h.mediarecyclerview.R
import uk.co.zac_h.mediarecyclerview.databinding.ListItemImageBinding
import uk.co.zac_h.mediarecyclerview.databinding.ListItemVideoBinding
import uk.co.zac_h.mediarecyclerview.models.MediaModel
import uk.co.zac_h.mediarecyclerview.ui.PhotoView
import uk.co.zac_h.mediarecyclerview.ui.VideoView
import uk.co.zac_h.mediarecyclerview.utils.MediaType
import uk.co.zac_h.mediarecyclerview.utils.setup
import kotlin.math.min

class MediaRecyclerAdapter(
    private val context: Context,
    private val media: ArrayList<MediaModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object Builder {
        private const val DEFAULT_MARGIN = 4

        private lateinit var media: ArrayList<MediaModel>
        private var margin: Int = DEFAULT_MARGIN

        fun setMargin(margin: Int?): Builder {
            this.margin = margin ?: DEFAULT_MARGIN
            return this
        }

        fun setMedia(media: ArrayList<MediaModel>): Builder {
            this.media = media
            return this
        }

        fun build(context: Context) = MediaRecyclerAdapter(context, media)
    }

    val spanSizeLookup: GridLayoutManager.SpanSizeLookup by lazy {
        object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int) = when (position) {
                0 -> if (media.size == 3) 2 else 1
                else -> 1
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            R.layout.list_item_image -> ImageViewHolder(
                ListItemImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.list_item_video -> VideoViewHolder(
                ListItemVideoBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid view type in MediaRecyclerAdapter")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = media[position]

        when (holder) {
            is ImageViewHolder -> holder.apply {
                with(binding) {
                    frameContainer.setOnClickListener {
                        context.startActivity(Intent(context, PhotoView::class.java).apply {
                            putExtra("position", position)
                            putParcelableArrayListExtra("media", media)
                        })
                    }

                    val frameContainerLayoutParams =
                        frameContainer.layoutParams as GridLayoutManager.LayoutParams

                    Glide.with(context).load(item.url).into(mediaImage)

                    when (position) {
                        0 -> {
                            when (media.size) {
                                3 -> ConstraintSet().setup(mediaContainer, mediaImage, "16:5")
                                2 -> ConstraintSet().setup(mediaContainer, mediaImage, "8:11")
                                else -> ConstraintSet().setup(mediaContainer, mediaImage, "16:10")
                            }
                            frameContainerLayoutParams.apply {
                                if (media.size > 1 && media.size != 3) marginEnd = margin
                                if (media.size >= 3) bottomMargin = margin
                            }
                        }
                        1 -> {
                            when (media.size) {
                                2 -> ConstraintSet().setup(mediaContainer, mediaImage, "8:11")
                                else -> ConstraintSet().setup(mediaContainer, mediaImage, "16:10")
                            }

                            frameContainerLayoutParams.apply {
                                if (media.size == 3) {
                                    marginEnd = margin
                                    topMargin = margin
                                }
                                if (media.size >= 4) {
                                    marginStart = margin
                                    bottomMargin = margin

                                }
                                if (media.size == 2) marginStart = margin
                            }
                        }
                        2 -> {
                            frameContainerLayoutParams.apply {
                                if (media.size == 3) {
                                    marginStart = margin
                                    topMargin = margin
                                }
                                if (media.size >= 4) {
                                    marginEnd = margin
                                    topMargin = margin
                                }
                            }
                        }
                        3 -> {
                            if (media.size > 3) {
                                frameContainerLayoutParams.apply {
                                    marginStart = margin
                                    topMargin = margin
                                }
                            }
                            if (media.size > 4) {
                                mediaCountContainer.visibility = View.VISIBLE
                                extraCount.text =
                                    context.getString(R.string.extra_count, media.size - 3)
                            } else {
                                mediaCountContainer.visibility = View.GONE
                            }
                        }
                    }
                }
            }
            is VideoViewHolder -> holder.apply {
                binding.videoContainer.setOnClickListener {
                    context.startActivity(Intent(context, VideoView::class.java).apply {
                        putExtra("media", item.url)
                    })
                }
                Glide.with(context).load(item.static).into(binding.videoStillImage)
            }
        }
    }

    override fun getItemCount(): Int = min(media.size, 4)

    override fun getItemViewType(position: Int): Int = when (media[position].type) {
        MediaType.IMAGE_URL, MediaType.IMAGE_RES -> R.layout.list_item_image
        MediaType.VIDEO -> R.layout.list_item_video
    }

    class ImageViewHolder(val binding: ListItemImageBinding) : RecyclerView.ViewHolder(binding.root)

    class VideoViewHolder(val binding: ListItemVideoBinding) : RecyclerView.ViewHolder(binding.root)
}