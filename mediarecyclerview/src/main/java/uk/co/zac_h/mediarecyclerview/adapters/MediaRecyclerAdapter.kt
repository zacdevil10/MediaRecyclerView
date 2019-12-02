package uk.co.zac_h.mediarecyclerview.adapters

import android.content.Context
import android.content.Intent
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.squareup.picasso.Picasso
import uk.co.zac_h.mediarecyclerview.R
import uk.co.zac_h.mediarecyclerview.models.MediaModel
import uk.co.zac_h.mediarecyclerview.ui.PhotoView
import uk.co.zac_h.mediarecyclerview.utils.MediaType
import kotlin.math.roundToInt

class MediaRecyclerAdapter(
    private val context: Context?,
    private val media: ArrayList<MediaModel>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object Builder {
        private const val DEFAULT_HEIGHT = 196

        private lateinit var media: ArrayList<MediaModel>
        private var height: Int? = null

        fun setHeight(height: Int): Builder {
            Builder.height = height
            return this
        }

        fun setMedia(media: ArrayList<MediaModel>): Builder {
            Builder.media = media
            return this
        }

        fun build(context: Context?): MediaRecyclerAdapter {
            return MediaRecyclerAdapter(
                context,
                media
            )
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
                        R.layout.list_item_image,
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
                image.setOnClickListener {
                    context?.startActivity(Intent(context, PhotoView::class.java).apply {
                        putExtra("position", position)
                        putParcelableArrayListExtra("media", media)
                    })
                }

                Picasso.get().load(item.url).into(image)

                val displayMetrics: DisplayMetrics? = context?.resources?.displayMetrics
                displayMetrics?.let {
                    val defaultHeight =
                        ((height
                            ?: DEFAULT_HEIGHT) * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()

                    when (position) {
                        0 -> {
                            if (media.size == 4) {
                                image.layoutParams.height = defaultHeight / 2
                                (image.layoutParams as StaggeredGridLayoutManager.LayoutParams).bottomMargin =
                                    8
                            }
                            if (media.size > 1) {
                                (image.layoutParams as StaggeredGridLayoutManager.LayoutParams).marginEnd =
                                    8
                            }
                        }
                        1 -> {
                            if (media.size > 2) {
                                image.layoutParams.height = defaultHeight / 2
                                (image.layoutParams as StaggeredGridLayoutManager.LayoutParams).bottomMargin =
                                    8

                            }
                            if (media.size > 1) {
                                (image.layoutParams as StaggeredGridLayoutManager.LayoutParams).marginStart =
                                    8
                            }
                        }
                        2 -> {
                            if (media.size > 2) {
                                image.layoutParams.height = defaultHeight / 2
                            }
                            if (media.size == 3) {
                                (image.layoutParams as StaggeredGridLayoutManager.LayoutParams).marginStart =
                                    8
                                (image.layoutParams as StaggeredGridLayoutManager.LayoutParams).topMargin =
                                    8
                            } else if (media.size == 4) {
                                (image.layoutParams as StaggeredGridLayoutManager.LayoutParams).marginEnd =
                                    8
                                (image.layoutParams as StaggeredGridLayoutManager.LayoutParams).topMargin =
                                    8
                            }
                        }
                        3 -> {
                            if (media.size > 3) {
                                image.layoutParams.height = defaultHeight / 2
                                (image.layoutParams as StaggeredGridLayoutManager.LayoutParams).marginStart =
                                    8
                                (image.layoutParams as StaggeredGridLayoutManager.LayoutParams).topMargin =
                                    8
                            }
                        }
                    }

                }
            }
        }
    }

    override fun getItemCount(): Int = media.size

    override fun getItemViewType(position: Int): Int =
        when (media[position].type) {
            MediaType.IMAGE -> 0
            MediaType.VIDEO -> 1
            else -> throw IllegalArgumentException("Unexpected media type found.")
        }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.media_image)
    }

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}