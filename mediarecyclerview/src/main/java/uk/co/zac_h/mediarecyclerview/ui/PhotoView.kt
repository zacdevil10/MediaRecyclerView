package uk.co.zac_h.mediarecyclerview.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uk.co.zac_h.mediarecyclerview.adapters.PhotoViewPagerAdapter
import uk.co.zac_h.mediarecyclerview.databinding.ActivityPhotoViewBinding
import uk.co.zac_h.mediarecyclerview.models.MediaModel

class PhotoView : AppCompatActivity() {

    private lateinit var binding: ActivityPhotoViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPhotoViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getParcelableArrayListExtra<MediaModel>("media")?.let {
            binding.photoViewPager.apply {
                adapter = PhotoViewPagerAdapter
                    .setImageType(it.map { it.type })
                    .build(context, it)
                currentItem = intent.extras?.get("position") as Int? ?: 0
            }
        }
    }
}
