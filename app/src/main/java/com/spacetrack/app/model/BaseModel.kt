package ca.aenv.dcl.model

import com.google.gson.annotations.SerializedName

open class BaseModel {
    @SerializedName("CreatedDate")
    var createdDate: String? = null // 2019-08-08T06:20:03.35
    @SerializedName("CreatedById")
    var createdById: String? = null
    @SerializedName("CreatedBy")
    var createdBy: String? = null
    @SerializedName("ModifiedDate")
    var modifiedDate: String? = null // 2019-08-08T06:20:03.35
    @SerializedName("ModifiedById")
    var modifiedById: String? = null
    @SerializedName("ModifiedBy")
    var modifiedBy: String? = null

}