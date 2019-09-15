package com.spacetrack.app.service

import com.spacetrack.app.api.repository.BaseRepository
import com.techgrains.service.TGIResponseListener
import com.techgrains.service.TGJsonArrayRequest
import com.techgrains.service.TGParams
import com.techgrains.service.TGResponse
import com.spacetrack.app.utils.Constants
import java.lang.reflect.Type
import java.util.*

class STAuthArrayRequest<T : TGResponse>(
    method: Int,
    url: String,
    listener: TGIResponseListener<TGResponse>,
    params: TGParams?,
    type: Type
) : TGJsonArrayRequest(method, url, listener, params, type, Constants.SERVICE_TIME_OUT, Constants.DEFAULT_MAX_RETRIES) {

    init {
        if (listener is BaseRepository.LGResponseListener)
            listener.request = this
    }

    override fun getHeaders(): Map<String, String> {
        val headers = HashMap<String, String>()
   //     headers[Constants.HEADER_AUTHORIZATION] = SharedPreferenceManager.instance.accessToken + ""
   //     headers[Constants.HEADER_FIREBASE] = SharedPreferenceManager.instance.firebaseToken + ""
        return headers
    }
}