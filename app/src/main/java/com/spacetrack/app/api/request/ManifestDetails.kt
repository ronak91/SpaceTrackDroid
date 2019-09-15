package com.spacetrack.app.api.request

import ca.aenv.dcl.model.BaseModel
import com.google.gson.annotations.SerializedName

/*
 */

class ManifestDetails : BaseModel() {

    @SerializedName("IdList")
    var releaseIdList: List<Int> = ArrayList()

//    @SerializedName("ManifestArrivalList")
//    var arrivalList: List<ArriveManifest> = ArrayList()

}
