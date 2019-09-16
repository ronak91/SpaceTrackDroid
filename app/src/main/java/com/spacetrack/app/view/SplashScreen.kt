package com.spacetrack.app.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.spacetrack.app.R

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launch_screen)

        Handler().postDelayed({
            var start = Intent(this, DashboardActivity::class.java);
            startActivity(start)
        },
        4000);


    }
}