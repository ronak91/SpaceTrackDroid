package com.spacetrack.app.utils

import android.content.Context
import com.techgrains.application.TGApplication

class STApplication : TGApplication() {

    override fun onCreate() {
        super.onCreate()
        context = this.applicationContext
    }

    companion object {
        lateinit var context: Context
    }
}