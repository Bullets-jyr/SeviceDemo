package kr.co.bullets.sevicedemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyBackgroundService : Service() {

    init{
        Log.i(TAG,"Service has been created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG,"Service Started")
        val name = intent?.getStringExtra(NAME)
        val marks = intent?.getIntExtra(MARKS,0)
        Log.i(TAG,"name is $name , marks : $marks")

        // this return value will be used by anroid system, to decide, how the system restarts the service after being destroyed by it
        return START_STICKY
    }

    override fun onDestroy() {
        Log.i(TAG,"Destroying....")
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null

    companion object{
        const val TAG = "MYTAG"
        const val NAME ="NAME"
        const val MARKS="TOTAL MARKS"
    }
}