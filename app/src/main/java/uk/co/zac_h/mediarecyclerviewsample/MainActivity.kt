package uk.co.zac_h.mediarecyclerviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val media = ArrayList<MediaModel>()

        val sampleMedia1 = ArrayList<String>().apply {
            add("https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg")
        }
        val sampleMedia2 = ArrayList<String>().apply {
            add("https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg")
            add("https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg")
        }
        val sampleMedia3 = ArrayList<String>().apply {
            add("https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg")
            add("https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg")
            add("https://pbs.twimg.com/media/EJsFuu4UYAAtUYA.jpg")
        }
        val sampleMedia4 = ArrayList<String>().apply {
            add("https://pbs.twimg.com/media/EKVaD0vUEAIjeXx.jpg")
            add("https://pbs.twimg.com/media/EKVaD0yU4AAttZz.jpg")
            add("https://pbs.twimg.com/media/EJsFuu4UYAAtUYA.jpg")
            add("https://pbs.twimg.com/media/EJsFuu6UEAA45aM.jpg")
        }

        media.add(MediaModel(1, sampleMedia1))
        media.add(MediaModel(2, sampleMedia2))
        media.add(MediaModel(3, sampleMedia3))
        media.add(MediaModel(4, sampleMedia4))

        sample_recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = SampleAdapter(context, media)
        }
    }
}
