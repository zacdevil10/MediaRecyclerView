package uk.co.zac_h.mediarecyclerview.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_photo_view.*
import uk.co.zac_h.mediarecyclerview.R
import uk.co.zac_h.mediarecyclerview.adapters.PhotoViewPagerAdapter
import uk.co.zac_h.mediarecyclerview.models.MediaModel

class PhotoView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_view)

        val media = intent.getParcelableArrayListExtra<MediaModel>("media")

        photo_view_pager.apply {
            adapter =
                PhotoViewPagerAdapter.setImageType(PhotoViewPagerAdapter.URL).build(context, media)
            currentItem = intent.extras?.get("position") as Int? ?: 0
        }
    }
}
