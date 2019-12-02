package uk.co.zac_h.mediarecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_photo_view.*

class PhotoView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_view)

        val media = intent.getStringArrayListExtra("media")

        photo_view_pager.apply {
            adapter = PhotoViewPagerAdapter.setImageType(PhotoViewPagerAdapter.URL).build(context, media)
            currentItem = intent.extras?.get("position") as Int? ?: 0
        }
    }
}
