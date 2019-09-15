package com.spacetrack.app.listner

import com.spacetrack.app.api.response.SyncResponse
import com.techgrains.service.TGResponse

interface SyncListener {
    fun onSuccess(response: TGResponse?)
    fun onError(response: TGResponse?)
}
