package uk.co.zac_h.mediarecyclerviewsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import uk.co.zac_h.mediarecyclerview.models.MediaModel
import uk.co.zac_h.mediarecyclerview.utils.MediaType
import uk.co.zac_h.mediarecyclerviewsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val media = ArrayList<SampleModel>()

        val sampleMedia1Video = ArrayList<MediaModel>().apply {
            add(
                MediaModel(
                    url = "https://video.twimg.com/ext_tw_video/1142505846317826048/pu/vid/1280x720/3dW5rOYOJxDQIQmh.mp4?tag=10",
                    static = "https://pbs.twimg.com/ext_tw_video_thumb/1191067166839377920/pu/img/qIOjEwDj0_eEZvbT.jpg",
                    type = MediaType.VIDEO
                )
            )
        }
        val sampleMedia1Image = ArrayList<MediaModel>().apply {
            add(
                MediaModel(
                    url = "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                    type = MediaType.IMAGE_URL
                )
            )
        }
        val sampleMedia2 = ArrayList<MediaModel>().apply {
            add(
                MediaModel(
                    url = "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                    type = MediaType.IMAGE_URL
                )
            )
            add(
                MediaModel(
                    url = "https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg",
                    type = MediaType.IMAGE_URL
                )
            )
        }
        val sampleMedia3 = ArrayList<MediaModel>().apply {
            add(
                MediaModel(
                    url = "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                    type = MediaType.IMAGE_URL
                )
            )
            add(
                MediaModel(
                    url = "https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg",
                    type = MediaType.IMAGE_URL
                )
            )
            add(
                MediaModel(
                    url = "https://pbs.twimg.com/media/EJsFuu4UYAAtUYA.jpg",
                    type = MediaType.IMAGE_URL
                )
            )
        }
        val sampleMedia4 = ArrayList<MediaModel>().apply {
            add(
                MediaModel(
                    url = "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                    type = MediaType.IMAGE_URL
                )
            )
            add(
                MediaModel(
                    url = "https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg",
                    type = MediaType.IMAGE_URL
                )
            )
            add(
                MediaModel(
                    url = "https://pbs.twimg.com/media/EJsFuu4UYAAtUYA.jpg",
                    type = MediaType.IMAGE_URL
                )
            )
            add(
                MediaModel(
                    url = "https://pbs.twimg.com/media/EJsFuu6UEAA45aM.jpg",
                    type = MediaType.IMAGE_URL
                )
            )
        }
        val sampleMedia5 = ArrayList<MediaModel>().apply {
            add(
                MediaModel(
                    url = "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                    type = MediaType.IMAGE_URL
                )
            )
            add(
                MediaModel(
                    url = "https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg",
                    type = MediaType.IMAGE_URL
                )
            )
            add(
                MediaModel(
                    url = "https://pbs.twimg.com/media/EJsFuu4UYAAtUYA.jpg",
                    type = MediaType.IMAGE_URL
                )
            )
            add(
                MediaModel(
                    url = "https://pbs.twimg.com/media/EJsFuu6UEAA45aM.jpg",
                    type = MediaType.IMAGE_URL
                )
            )
            add(
                MediaModel(
                    url = "https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg",
                    type = MediaType.IMAGE_URL
                )
            )
            add(
                MediaModel(
                    url = "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                    type = MediaType.IMAGE_URL
                )
            )
        }

        val sampleMedia6 = ArrayList<MediaModel>()

        media.add(SampleModel(1, sampleMedia1Image))
        media.add(SampleModel(2, sampleMedia2))
        media.add(SampleModel(3, sampleMedia3))
        media.add(SampleModel(4, sampleMedia4))
        media.add(SampleModel(5, sampleMedia5))
        media.add(SampleModel(6, sampleMedia6))

        binding.sampleRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = SampleAdapter(media)
        }
    }
}
