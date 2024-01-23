package com.example.servicesapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
    
            if(intent?.action != null && intent.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
                var bool = intent.getBooleanExtra("state",false)

                if (bool){
                    Toast.makeText(context, "AIRPLANE MODE ON", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "AIRPLANE MODE OFF", Toast.LENGTH_SHORT).show()
                }

            }
            }
}