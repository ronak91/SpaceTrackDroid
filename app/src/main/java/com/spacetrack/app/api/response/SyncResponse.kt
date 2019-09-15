package com.spacetrack.app.api.response

import com.spacetrack.app.model.Refs
import com.google.gson.annotations.SerializedName
import com.techgrains.service.TGResponse

open class SyncResponse() : TGResponse() {

    @SerializedName("IsSuccess")
    var success: Boolean = true
    @SerializedName("DataModelList")
    var dataList: List<Model> = ArrayList()
    @SerializedName("ReferenceNumberIdList")
    var refList: List<RefsUuid> = ArrayList()

    constructor(_success:Boolean) : this() {
        this.success = _success
    }
    inner class Model {
        @SerializedName("Id")
        val id: Long? = 0
        @SerializedName("UniqueGuid")
        val uuid: String? = null
        @SerializedName("Message")
        val message: String? = null
    }
    class RefsUuid {
        @SerializedName("Id")
        val id: Long? = 0
        @SerializedName("UniqueReferenceNumberId")
        val uuid: String? = null
    }

}

