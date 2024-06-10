package com.example.timerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.provider.AlarmClock

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMilk: Button = findViewById(R.id.btnMilk)
        val btnWaterMotor: Button = findViewById(R.id.btnWaterMotor)
        val btnToast: Button = findViewById(R.id.btnToast)

        btnMilk.setOnClickListener {
            startTimer("Milk Timer", 180)  // 3 minutes
        }

        btnWaterMotor.setOnClickListener {
            startTimer("Water Motor Timer", 180)  // 3 minutes
        }

        btnToast.setOnClickListener {
            startTimer("Toast Timer", 180)  // 3 minutes
        }
    }

    private fun startTimer(message: String, seconds: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_LENGTH, seconds)
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
        }
//        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
//        }
    }
}
