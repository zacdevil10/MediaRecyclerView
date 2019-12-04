package uk.co.zac_h.mediarecyclerview.ui

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_video_view.*
import uk.co.zac_h.mediarecyclerview.R

class VideoView : AppCompatActivity() {

    private var media: String? = null

    private var player: SimpleExoPlayer? = null

    private var playWhenReady = true
    private var playbackPosition: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)

        media = intent.extras?.getString("media")

        if (savedInstanceState != null) {
            playbackPosition = savedInstanceState.getLong("playback_position")
            playWhenReady = savedInstanceState.getBoolean("play_when_ready")
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT >= 24) initPlayer()
    }

    override fun onResume() {
        super.onResume()
        if ((Util.SDK_INT < 24 || player == null)) initPlayer()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putLong("playback_position", playbackPosition)
        outState.putBoolean("play_when_ready", playWhenReady)
        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT < 24) releasePlayer()
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT >= 24) releasePlayer()
    }

    private fun initPlayer() {
        player = ExoPlayerFactory.newSimpleInstance(this)
        video_view.player = player

        val uri = Uri.parse(media)
        val mediaSource: MediaSource = buildMediaSource(uri)

        player?.apply {
            playWhenReady = this@VideoView.playWhenReady
            prepare(mediaSource)
            seekTo(playbackPosition)
        }
    }

    private fun releasePlayer() {
        player?.let {
            playWhenReady = it.playWhenReady
            playbackPosition = it.currentPosition
            it.release()
            player = null
        }
    }

    private fun buildMediaSource(uri: Uri): MediaSource {
        val dataSourceFactory: DataSource.Factory =
            DefaultDataSourceFactory(this, "MediaRecyclerView")
        return ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri)
    }
}
