package com.spacetrack.app.api.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.spacetrack.app.utils.Constants
import com.android.volley.Request
import com.spacetrack.app.R
import com.spacetrack.app.listner.SyncListener
import com.spacetrack.app.util.STUtil
import com.techgrains.model.dialog.TGAlertDialog
import com.techgrains.service.TGIResponseListener
import com.techgrains.service.TGResponse

open class BaseRepository(val app: Application) {

    private val logout = MutableLiveData<Void>()
    val apiError = MediatorLiveData<TGAlertDialog>()

    companion object{
        @JvmStatic
        protected val isLoading = MediatorLiveData<Int>()
    }

    fun getLoading(): LiveData<Int> = isLoading
    fun getLogoutResponse(): LiveData<Void> = logout

    fun showLoader(){
        isLoading.postValue((isLoading.value ?: 0).plus(1))
        Log.d(Constants.TAG, "BaseRepository showLoader : "+isLoading.value)
    }
    fun hideLoader(){
        isLoading.postValue((isLoading.value ?:1).minus(1))
        if(isLoading.value ?: 0 < 0) isLoading.value = 0
        Log.d(Constants.TAG, "BaseRepository hideLoader : "+isLoading.value)
    }

    fun hideLoaderForce(){
        isLoading.value = 0
        Log.d(Constants.TAG, "BaseRepository hideLoaderForce : "+isLoading.value)
    }


    abstract inner class LGResponseListener<T : TGResponse>(val listener: SyncListener? = null, val showAlert: Boolean = true) : TGIResponseListener<T> {
        var request: Request<*>? = null
        override fun onSuccessBackgroundThread(p0: T) {}

        override fun onError(response: TGResponse?) {
            if (showAlert) handlerErrorResponse(response, request)
            listener?.onError(response)
        }
    }

    fun handlerErrorResponse(response: TGResponse?, request: Request<*>?) {
        Log.e(Constants.TAG, "API ERROR : [${request?.url}]  ${response?.networkResponse}  ${response?.statusCode} ${response?.error?.detailMessage}")
        val errorResponse = if(response?.isTimeout == true) "Service Timeout. Please connect to better network"
        else STUtil.convertJsonToErrorResponse(response?.networkResponse)
        apiError.postValue(TGAlertDialog(null, errorResponse, app.getString(R.string.ok)))
        isLoading.value = 0
    }


}