package com.spacetrack.app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launch_screen)

        Handler().postDelayed({
            var start = Intent(this,MainActivity::class.java);
            startActivity(start)
        },
        4000);


    }
}