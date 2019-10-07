package com.saucefan.stuff.additionalandroidm01

import android.graphics.drawable.Animatable
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mp:MediaPlayer
    private val workManager = WorkManager.getInstance(application)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        play_pause_button.isEnabled = false


        //todo 3 seeeekbears.com
        seekbears()

    }

    override fun onStart() {
        super.onStart()


        video_view.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.samplevideo))

        video_view.setOnPreparedListener {
            mp=it
            play_pause_button.isEnabled = true
            mp.let {
                video_seek_bar.max = mp.duration
            }

        }

        play_pause_button.setOnClickListener {

            if (video_view.isPlaying) {
                //pause
                play_pause_button.setImageDrawable(getDrawable(R.drawable.avd_anim_play_pause))
                video_view.pause()
            } else {
                //play

                play_pause_button.setImageDrawable(getDrawable(R.drawable.avd_anim_pause_play))
                video_view.start()
            }
            val pbtnAnim = play_pause_button.drawable
            if (pbtnAnim is Animatable) {
                pbtnAnim.start()
            }
        }


    }

    override fun onStop() {

        video_view.pause()
        super.onStop()
    }

    fun seekbears() {
        video_seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                video_view.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

    }


}
