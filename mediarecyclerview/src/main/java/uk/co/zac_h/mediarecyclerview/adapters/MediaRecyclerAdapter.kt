package uk.co.zac_h.mediarecyclerview.adapters

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uk.co.zac_h.mediarecyclerview.R
import uk.co.zac_h.mediarecyclerview.models.MediaModel
import uk.co.zac_h.mediarecyclerview.ui.PhotoView
import uk.co.zac_h.mediarecyclerview.ui.VideoView
import uk.co.zac_h.mediarecyclerview.utils.MediaType
import kotlin.math.min

class MediaRecyclerAdapter(
    private val activity: Activity,
    private val context: Context?,
    private val media: ArrayList<MediaModel>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object Builder {
        private const val DEFAULT_MARGIN = 4

        private lateinit var media: ArrayList<MediaModel>
        private var margin: Int? = null

        fun setMargin(margin: Int?): Builder {
            Builder.margin = margin
            return this
        }

        fun setMedia(media: ArrayList<MediaModel>): Builder {
            Builder.media = media
            return this
        }

        fun build(activity: Activity, context: Context?): MediaRecyclerAdapter {
            return MediaRecyclerAdapter(
                activity,
                context,
                media
            )
        }
    }

    val spanSizeLookup: GridLayoutManager.SpanSizeLookup by lazy {
        object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    0 -> if (media.size == 3) 2 else 1
                    else -> 1
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            MediaType.IMAGE -> {
                ImageViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.list_item_image,
                        parent,
                        false
                    )
                )
            }
            MediaType.VIDEO -> {
                VideoViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.list_item_video,
                        parent,
                        false
                    )
                )
            }
            else -> throw IllegalArgumentException("Invalid view type in MediaRecyclerAdapter")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = media[position]

        when (holder) {
            is ImageViewHolder -> holder.apply {
                frameContainer.setOnClickListener {
                    val options = ActivityOptions.makeSceneTransitionAnimation(activity, frameContainer, item.url)
                    context?.startActivity(Intent(context, PhotoView::class.java).apply {
                        putExtra("position", position)
                        putExtra("transition", item.url)
                        putParcelableArrayListExtra("media", media)
                    }, options.toBundle())
                }

                frameContainer.transitionName = item.url

                Picasso.get().load(item.url).into(image)

                when (position) {
                    0 -> {
                        when (media.size) {
                            3 -> {
                                ConstraintSet().apply {
                                    clone(container)
                                    setDimensionRatio(image.id, "16:5")
                                    applyTo(container)
                                }
                            }
                            2 -> {
                                ConstraintSet().apply {
                                    clone(container)
                                    setDimensionRatio(image.id, "8:11")
                                    applyTo(container)
                                }
                            }
                            else -> {
                                ConstraintSet().apply {
                                    clone(container)
                                    setDimensionRatio(image.id, "16:10")
                                    applyTo(container)
                                }
                            }
                        }
                        if (media.size > 1 && media.size != 3) {
                            (frameContainer.layoutParams as GridLayoutManager.LayoutParams).marginEnd =
                                margin ?: DEFAULT_MARGIN
                        }
                        if (media.size >= 3) {
                            (frameContainer.layoutParams as GridLayoutManager.LayoutParams).bottomMargin =
                                margin ?: DEFAULT_MARGIN
                        }
                    }
                    1 -> {
                        when (media.size) {
                            2 -> {
                                ConstraintSet().apply {
                                    clone(container)
                                    setDimensionRatio(image.id, "8:11")
                                    applyTo(container)
                                }
                            }
                            else -> {
                                ConstraintSet().apply {
                                    clone(container)
                                    setDimensionRatio(image.id, "16:10")
                                    applyTo(container)
                                }
                            }
                        }

                        if (media.size == 3) {
                            (frameContainer.layoutParams as GridLayoutManager.LayoutParams).marginEnd =
                                margin ?: DEFAULT_MARGIN
                            (frameContainer.layoutParams as GridLayoutManager.LayoutParams).topMargin =
                                margin ?: DEFAULT_MARGIN
                        }
                        if (media.size >= 4) {
                            (frameContainer.layoutParams as GridLayoutManager.LayoutParams).marginStart =
                                margin ?: DEFAULT_MARGIN
                            (frameContainer.layoutParams as GridLayoutManager.LayoutParams).bottomMargin =
                                margin ?: DEFAULT_MARGIN
                        }
                        if (media.size == 2) {
                            (frameContainer.layoutParams as GridLayoutManager.LayoutParams).marginStart =
                                margin ?: DEFAULT_MARGIN
                        }
                    }
                    2 -> {
                        if (media.size == 3) {
                            (frameContainer.layoutParams as GridLayoutManager.LayoutParams).marginStart =
                                margin ?: DEFAULT_MARGIN
                            (frameContainer.layoutParams as GridLayoutManager.LayoutParams).topMargin =
                                margin ?: DEFAULT_MARGIN
                        }
                        if (media.size >= 4) {
                            (frameContainer.layoutParams as GridLayoutManager.LayoutParams).marginEnd =
                                margin ?: DEFAULT_MARGIN
                            (frameContainer.layoutParams as GridLayoutManager.LayoutParams).topMargin =
                                margin ?: DEFAULT_MARGIN
                        }
                    }
                    3 -> {
                        if (media.size > 3) {

                            (frameContainer.layoutParams as GridLayoutManager.LayoutParams).marginStart =
                                margin ?: DEFAULT_MARGIN
                            (frameContainer.layoutParams as GridLayoutManager.LayoutParams).topMargin =
                                margin ?: DEFAULT_MARGIN
                        }
                        if (media.size > 4) {
                            countContainer.visibility = View.VISIBLE
                            countText.text = "+${media.size - 3}"
                        } else {
                            countContainer.visibility = View.GONE
                        }
                    }
                }
            }
            is VideoViewHolder -> holder.apply {
                container.setOnClickListener {
                    context?.startActivity(Intent(context, VideoView::class.java).apply {
                        putExtra("media", item.url)
                    })
                }
                Picasso.get().load(item.static).into(videoStill)
            }
        }
    }

    override fun getItemCount(): Int = min(media.size, 4)

    override fun getItemViewType(position: Int): Int =
        when (media[position].type) {
            MediaType.IMAGE -> 0
            MediaType.VIDEO -> 1
            else -> throw IllegalArgumentException("Unexpected media type found.")
        }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val frameContainer: FrameLayout = itemView.findViewById(R.id.frame_container)
        val container: ConstraintLayout = itemView.findViewById(R.id.media_container)
        val image: ImageView = itemView.findViewById(R.id.media_image)

        val countContainer: FrameLayout = itemView.findViewById(R.id.media_count_container)
        val countText: TextView = itemView.findViewById(R.id.extra_count)
    }

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val container: FrameLayout = itemView.findViewById(R.id.video_container)
        val videoStill: ImageView = itemView.findViewById(R.id.video_still_image)
    }
}