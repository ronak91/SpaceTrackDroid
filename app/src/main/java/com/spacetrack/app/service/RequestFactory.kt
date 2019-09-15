package com.spacetrack.app.service


import android.util.Log
import com.android.volley.Request
import com.google.gson.reflect.TypeToken
import com.spacetrack.app.R
import com.spacetrack.app.model.Manifest
import com.spacetrack.app.api.repository.BaseRepository
import com.spacetrack.app.utils.Constants
import com.spacetrack.app.utils.STApplication
import com.techgrains.service.TGResponse

object RequestFactory {

    private val baseUrl: String
        get() = STApplication.context.getString(R.string.BASE_URL)

    fun getUrl(service: Int): String {
        return baseUrl + STApplication.context.getString(service)
    }

    fun getPendingManifest(listener: BaseRepository.LGResponseListener<TGResponse>): STAuthArrayRequest<TGResponse> {
        val url = getUrl(R.string.GET_PENDING_TR)
        Log.w(Constants.TAG, "POST $url  ")
        return STAuthArrayRequest(Request.Method.GET, url, listener, null, object : TypeToken<List<Manifest>>() {}.type)
    }

}