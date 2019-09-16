package com.spacetrack.app.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.spacetrack.app.R

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val btnAgencies = findViewById<LinearLayout>(R.id.btnAgencies)
        val btnAstronaut = findViewById<LinearLayout>(R.id.btnAstronaut)
        val btnSpacecraft = findViewById<LinearLayout>(R.id.btnSpacecraft)
        val btnLauncher = findViewById<LinearLayout>(R.id.btnLauncher)
        val btnLaunch = findViewById<LinearLayout>(R.id.btnLaunch)
        val btnEvent = findViewById<LinearLayout>(R.id.btnEvent)

        goToActivity("AgenciesActivity");


    }

    fun goToActivity(Actvity : String){
        var start = Intent(this, Actvity::class.java);
        startActivity(start)
    }


    fun View.OnClickListener() {

    }

}