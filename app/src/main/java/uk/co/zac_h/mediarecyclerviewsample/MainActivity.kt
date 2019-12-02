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

        val sampleMedia1 = ArrayList<MediaModel>().apply {
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

        media.add(SampleModel(1, sampleMedia1))
        media.add(SampleModel(2, sampleMedia2))
        media.add(SampleModel(3, sampleMedia3))
        media.add(SampleModel(4, sampleMedia4))

        sample_recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = SampleAdapter(context, media)
        }
    }
}
