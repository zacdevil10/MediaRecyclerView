package uk.co.zac_h.mediarecyclerview.ui

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialContainerTransformSharedElementCallback
import kotlinx.android.synthetic.main.activity_photo_view.*
import uk.co.zac_h.mediarecyclerview.R
import uk.co.zac_h.mediarecyclerview.adapters.PhotoViewPagerAdapter
import uk.co.zac_h.mediarecyclerview.models.MediaModel

class PhotoView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_view)

        val transitionName = intent.getStringExtra("transition")

        photo_view_pager.transitionName = transitionName

        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())

        window.sharedElementEnterTransition = MaterialContainerTransform(this).apply {
            addTarget(photo_view_pager)
            duration = 400
        }

        val media = intent.getParcelableArrayListExtra<MediaModel>("media")

        photo_view_pager.apply {
            adapter =
                PhotoViewPagerAdapter.setImageType(PhotoViewPagerAdapter.URL).build(context, media)
            currentItem = intent.extras?.get("position") as Int? ?: 0
        }
    }
}
