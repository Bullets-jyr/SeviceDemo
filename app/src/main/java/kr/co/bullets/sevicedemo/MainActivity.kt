package kr.co.bullets.sevicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.co.bullets.sevicedemo.MyBackgroundService.Companion.MARKS
import kr.co.bullets.sevicedemo.MyBackgroundService.Companion.NAME
import kr.co.bullets.sevicedemo.MyBackgroundService.Companion.TAG
import kr.co.bullets.sevicedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val serviceIntent = Intent(this, MyBackgroundService::class.java)
        serviceIntent.putExtra(NAME,"Alex")
        serviceIntent.putExtra(MARKS,78)

        binding.btnStart.setOnClickListener {
            Log.i(TAG,"Starting service")
            startService(serviceIntent)
        }

        binding.btnStop.setOnClickListener {
            Log.i(TAG,"Stopping service")
            stopService(serviceIntent)
        }
    }
}