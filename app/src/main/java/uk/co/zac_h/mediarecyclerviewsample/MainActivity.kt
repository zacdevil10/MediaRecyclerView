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

        val sampleMedia1Video = arrayListOf(
            MediaModel(
                url = "https://video.twimg.com/ext_tw_video/1142505846317826048/pu/vid/1280x720/3dW5rOYOJxDQIQmh.mp4?tag=10",
                static = "https://pbs.twimg.com/ext_tw_video_thumb/1191067166839377920/pu/img/qIOjEwDj0_eEZvbT.jpg",
                type = MediaType.VIDEO
            )
        )
        val sampleMedia1Image = arrayListOf(
            MediaModel(
                url = "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                type = MediaType.IMAGE_URL
            )
        )
        val sampleMedia2 = arrayListOf(
            MediaModel(
                url = "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                type = MediaType.IMAGE_URL
            ),
            MediaModel(
                url = "https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg",
                type = MediaType.IMAGE_URL
            )
        )
        val sampleMedia3 = arrayListOf(
            MediaModel(
                url = "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                type = MediaType.IMAGE_URL
            ),
            MediaModel(
                url = "https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg",
                type = MediaType.IMAGE_URL
            ),
            MediaModel(
                url = "https://pbs.twimg.com/media/EJsFuu4UYAAtUYA.jpg",
                type = MediaType.IMAGE_URL
            )
        )
        val sampleMedia4 = arrayListOf(
            MediaModel(
                url = "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                type = MediaType.IMAGE_URL
            ),
            MediaModel(
                url = "https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg",
                type = MediaType.IMAGE_URL
            ),
            MediaModel(
                url = "https://pbs.twimg.com/media/EJsFuu4UYAAtUYA.jpg",
                type = MediaType.IMAGE_URL
            ),
            MediaModel(
                url = "https://pbs.twimg.com/media/EJsFuu6UEAA45aM.jpg",
                type = MediaType.IMAGE_URL
            )
        )
        val sampleMedia5 = arrayListOf(
            MediaModel(
                url = "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                type = MediaType.IMAGE_URL
            ),
            MediaModel(
                url = "https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg",
                type = MediaType.IMAGE_URL
            ),
            MediaModel(
                url = "https://pbs.twimg.com/media/EJsFuu4UYAAtUYA.jpg",
                type = MediaType.IMAGE_URL
            ),
            MediaModel(
                url = "https://pbs.twimg.com/media/EJsFuu6UEAA45aM.jpg",
                type = MediaType.IMAGE_URL
            ),
            MediaModel(
                url = "https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg",
                type = MediaType.IMAGE_URL
            ),
            MediaModel(
                url = "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                type = MediaType.IMAGE_URL
            )
        )

        binding.sampleRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = SampleAdapter(
                arrayListOf(
                    SampleModel(1, sampleMedia1Image),
                    SampleModel(2, sampleMedia2),
                    SampleModel(3, sampleMedia3),
                    SampleModel(4, sampleMedia4),
                    SampleModel(5, sampleMedia5),
                    SampleModel(6, arrayListOf()),
                )
            )
        }
    }
}
