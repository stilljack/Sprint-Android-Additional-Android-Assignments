package com.saucefan.stuff.additionalandroidm01

import android.graphics.Color
import android.graphics.drawable.Animatable
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.SeekBar
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.saucefan.stuff.additionalandroidm01.work.ProgressWorker
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Duration
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var mp:MediaPlayer
    val handler = Handler()
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





        video_view.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.live_views_of_starman))

        video_view.setOnPreparedListener {
            mp=it
            play_pause_button.isEnabled = true
            video_seek_bar.max = (mp.duration/100)


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
      startProgressRefreshTimer(1000L)
    }

    override fun onStop() {

        video_view.pause()
        super.onStop()
    }


    fun startProgressRefreshTimer(delayM: Long) {
        handler.postDelayed(object : Runnable {
            override fun run() {
                video_seek_bar.setBackgroundColor(randomHSVColor())
                val cur=mp.currentPosition/100
                video_seek_bar.progress=(cur)


                handler.postDelayed(this, delayM)
            }
        }, delayM)

    }
    fun randomHSVColor(): Int {
        val mRandom = Random
        val hue = mRandom.nextInt(361)
        val saturation = 1.0f
        val value = 1.0f
        val alpha = 255
        return Color.HSVToColor(alpha, floatArrayOf(hue.toFloat(), saturation, value))
    }
    object RepeatHelper {
        fun repeatDelayed(delay: Long, todo: () -> Unit) {
            val handler = Handler()
            handler.postDelayed(object : Runnable {
                override fun run() {
                    todo()
                    handler.postDelayed(this, delay)
                }
            }, delay)
        }
    }
    fun seekbears() {
        video_seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) {
                    val cur = progress * 100
                    val curMp = mp.currentPosition / 100

                    if (cur >= (curMp + 200) || cur <= (curMp - 200)) {
                        mp.seekTo(cur)
                    }
                }




            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

    }


}
