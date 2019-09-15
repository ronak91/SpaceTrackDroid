package com.spacetrack.app.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Refs(
    @SerializedName("Id") var id: Int? = null,
    @SerializedName("TRId") var trId: Int? = null,
    @SerializedName("Number") var number: String? = null,
    @SerializedName("UniqueReferenceNumberId") var uuid: String? = null,
    @SerializedName("RowVersion") var rowVersion: String? = null,
    @SerializedName("AssociatedDoc") var associatedDoc: String? = null,
    @SerializedName("AssociatedDocName") var associatedDocName: String? = null,
    @SerializedName("AssociatedDocUrl") var associatedDocUrl: String? = null,
    @SerializedName("ReferenceTypeId") var referenceTypeId: Int? = null,
    @SerializedName("ReferenceTypeName") var referenceTypeName: String? = null,
    var localFilePath: String? = null,
    var isSynced: Boolean = true,
    var deleteSynced: Boolean = true,
    var fileSynced: Boolean = true,
    @SerializedName("isDeleted") var isDeleted: Boolean = false,
    @SerializedName("CreatedBy") var createdBy: String? = null,
    @SerializedName("CreatedById") var createdById: String? = null,
    @SerializedName("ModifiedBy") var modifiedBy: String? = null,
    @SerializedName("ModifiedDate") var modifiedDate: String? = null,
    @SerializedName("CreatedDate") var createdDate: String? = null

)