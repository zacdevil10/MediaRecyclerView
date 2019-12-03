package uk.co.zac_h.mediarecyclerviewsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uk.co.zac_h.mediarecyclerview.ui.MediaRecyclerView

class SampleAdapter(private val context: Context?, private val media: ArrayList<SampleModel>) :
    RecyclerView.Adapter<SampleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_sample,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = media[position]

        holder.apply {
            textView.text = item.itemNumber.toString()

            recycler.apply {
                height(200)
                setMargin(4)
                configure(context, item.itemUrl)
            }
        }
    }

    override fun getItemCount(): Int = media.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.sample_item_text)
        val recycler: MediaRecyclerView = itemView.findViewById(R.id.media_recycler)
    }
}
