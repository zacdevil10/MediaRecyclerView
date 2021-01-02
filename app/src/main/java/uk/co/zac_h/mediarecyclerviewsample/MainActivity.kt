package uk.co.zac_h.mediarecyclerviewsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.zac_h.mediarecyclerview.models.MediaModel
import uk.co.zac_h.mediarecyclerview.utils.MediaType

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val media = ArrayList<SampleModel>()

        val sampleMedia1Video = ArrayList<MediaModel>().apply {
            add(
                MediaModel(
                    "https://video.twimg.com/ext_tw_video/1142505846317826048/pu/vid/1280x720/3dW5rOYOJxDQIQmh.mp4?tag=10",
                    MediaType.VIDEO,
                    "https://pbs.twimg.com/ext_tw_video_thumb/1191067166839377920/pu/img/qIOjEwDj0_eEZvbT.jpg"
                )
            )
        }
        val sampleMedia1Image = ArrayList<MediaModel>().apply {
            add(
                MediaModel(
                    "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                    MediaType.IMAGE
                )
            )
        }
        val sampleMedia2 = ArrayList<MediaModel>().apply {
            add(
                MediaModel(
                    "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                    MediaType.IMAGE
                )
            )
            add(
                MediaModel(
                    "https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg",
                    MediaType.IMAGE
                )
            )
        }
        val sampleMedia3 = ArrayList<MediaModel>().apply {
            add(
                MediaModel(
                    "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                    MediaType.IMAGE
                )
            )
            add(
                MediaModel(
                    "https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg",
                    MediaType.IMAGE
                )
            )
            add(
                MediaModel(
                    "https://pbs.twimg.com/media/EJsFuu4UYAAtUYA.jpg",
                    MediaType.IMAGE
                )
            )
        }
        val sampleMedia4 = ArrayList<MediaModel>().apply {
            add(
                MediaModel(
                    "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                    MediaType.IMAGE
                )
            )
            add(
                MediaModel(
                    "https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg",
                    MediaType.IMAGE
                )
            )
            add(
                MediaModel(
                    "https://pbs.twimg.com/media/EJsFuu4UYAAtUYA.jpg",
                    MediaType.IMAGE
                )
            )
            add(
                MediaModel(
                    "https://pbs.twimg.com/media/EJsFuu6UEAA45aM.jpg",
                    MediaType.IMAGE
                )
            )
        }
        val sampleMedia5 = ArrayList<MediaModel>().apply {
            add(
                MediaModel(
                    "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                    MediaType.IMAGE
                )
            )
            add(
                MediaModel(
                    "https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg",
                    MediaType.IMAGE
                )
            )
            add(
                MediaModel(
                    "https://pbs.twimg.com/media/EJsFuu4UYAAtUYA.jpg",
                    MediaType.IMAGE
                )
            )
            add(
                MediaModel(
                    "https://pbs.twimg.com/media/EJsFuu6UEAA45aM.jpg",
                    MediaType.IMAGE
                )
            )
            add(
                MediaModel(
                    "https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg",
                    MediaType.IMAGE
                )
            )
            add(
                MediaModel(
                    "https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg",
                    MediaType.IMAGE
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

        sample_recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = SampleAdapter(this@MainActivity, media)
        }
    }
}
