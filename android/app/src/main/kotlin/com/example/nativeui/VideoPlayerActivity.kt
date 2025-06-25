//
package com.example.nativeui

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView

class VideoPlayerActivity : AppCompatActivity() {
    private var player: ExoPlayer? = null  // Make player nullable
    private lateinit var playerView: PlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        val videoUrl = intent.getStringExtra("VIDEO_URL")

        playerView = findViewById(R.id.player_view)
        initializePlayer(videoUrl)
    }

    private fun initializePlayer(videoUrl: String?) {
        player = ExoPlayer.Builder(this).build()
        playerView.player = player  // Assign the nullable player to playerView

        videoUrl?.let {
            val mediaItem = MediaItem.fromUri(Uri.parse(it))
            player?.setMediaItem(mediaItem)
            player?.prepare()
            player?.play()
        }
    }

    override fun onStop() {
        super.onStop()
        player?.release()  // Release the player safely
        player = null
    }
}
