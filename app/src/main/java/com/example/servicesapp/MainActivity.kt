package com.example.servicesapp

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var button2:Button

    lateinit var airplaneModeReceiver:AirplaneModeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)

        button.setOnClickListener(){
            var start = Intent(
                this,
                MyService::class.java
            )
            startService(start)

        }

        button2.setOnClickListener(){
            var stop = Intent(
                this, MyService::class.java
            )
            stopService(stop)
        }

        var intentFilter = IntentFilter("android.intent.action.AIRPLANE_MODE")

        airplaneModeReceiver = AirplaneModeReceiver()

        registerReceiver(airplaneModeReceiver, intentFilter)
    }

    override fun onDestroy() {
        unregisterReceiver(airplaneModeReceiver)
        super.onDestroy()

    }
}