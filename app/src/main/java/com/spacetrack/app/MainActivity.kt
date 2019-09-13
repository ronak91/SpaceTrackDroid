package com.spacetrack.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.spacetrack.app.view.UsersListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frag_container, UsersListFragment()).commit()
        }

    }
}

