package com.example.servicesapp

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.os.Parcel
import android.os.Parcelable
import android.provider.Settings

class MyService() : Service(){


    lateinit var mediaplayer:MediaPlayer


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        mediaplayer = MediaPlayer.create(
            this,
            Settings.System.DEFAULT_ALARM_ALERT_URI
        )

        mediaplayer.isLooping
        mediaplayer.start()
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onDestroy() {
        super.onDestroy()
        mediaplayer.stop()
    }

}