package com.example.audio

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.Locale
import kotlin.time.Duration.Companion.milliseconds

class MainActivity : AppCompatActivity() {

    fun formatTime(ms: Int): String {
        val sec = ms / 1000
        return String.format(Locale.getDefault(), "%02d:%02d", sec / 60, sec % 60)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mp = MediaPlayer.create(this, R.raw.let_there_be_rock)

        val btnPlay = findViewById<Button>(R.id.playBtn)
        val btnPause = findViewById<Button>(R.id.pauseBtn)
        val btnStop = findViewById<Button>(R.id.stopBtn)
        val mediaTime = findViewById<SeekBar>(R.id.mediaTime)
        val volumeSlider = findViewById<SeekBar>(R.id.volumeBar)
        val currentTime = findViewById<TextView>(R.id.currentTime)
        val totalTime = findViewById<TextView>(R.id.totalTime)

        var posicionActual = 0
        var updateJob: Job? = null
        var isDraggingSeekbar = false

        volumeSlider.max = 100
        volumeSlider.progress = 100

        totalTime.text = formatTime(mp.duration)
        mediaTime.max = mp.duration
        currentTime.text = formatTime(0)

        fun stopUpdating() {
            updateJob?.cancel()
            updateJob = null
        }

        fun startUpdating() {
            updateJob?.cancel()
            updateJob = lifecycleScope.launch {
                while (isActive) {
                    if (!isDraggingSeekbar) {
                        val position = mp.currentPosition
                        mediaTime.progress = position
                        currentTime.text = formatTime(position)
                    }
                    delay(200.milliseconds)
                }
            }
        }

        lifecycle.addObserver(LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_DESTROY) {
                updateJob?.cancel()
                mp.release()
            }
        })

        volumeSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {
                val v = progress / 100f
                mp.setVolume(v, v)
            }

            override fun onStartTrackingTouch(sb: SeekBar?) {}
            override fun onStopTrackingTouch(sb: SeekBar?) {}
        })

        mediaTime.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) currentTime.text = formatTime(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                isDraggingSeekbar = true
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                isDraggingSeekbar = false
                val songProgress = seekBar?.progress ?: 0
                mp.seekTo(songProgress)
                posicionActual = songProgress
            }
        })

        mp.setOnCompletionListener {
            stopUpdating()
            posicionActual = 0
            mediaTime.progress = 0
            currentTime.text = formatTime(0)
        }

        btnPlay.setOnClickListener {
            if (!mp.isPlaying) {
                if (posicionActual > 0) mp.seekTo(posicionActual)
                mp.start()
                startUpdating()
            }
        }

        btnPause.setOnClickListener {
            if (mp.isPlaying) {
                posicionActual = mp.currentPosition
                mp.pause()
                stopUpdating()
            }
        }

        btnStop.setOnClickListener {
            if (mp.isPlaying) mp.pause()
            mp.seekTo(0)
            posicionActual = 0
            stopUpdating()
            mediaTime.progress = 0
            currentTime.text = formatTime(0)
        }
    }
}