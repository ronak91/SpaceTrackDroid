package com.spacetrack.app.model

import ca.aenv.dcl.model.BaseModel
import com.spacetrack.app.utils.Constants
import com.google.gson.annotations.SerializedName
import java.text.DecimalFormat

class ManifestCargo() : BaseModel() {

    var localId: Long? = null

    @SerializedName("ManifestId")
    var manifestId: Int? = null
    
    @SerializedName("ReceivedCargoId")
    var cargoId: Int? = null
    
    @SerializedName("CargoTypeId")
    var cargoTypeId: Int? = null
    
    @SerializedName("ShipmentNumber")
    var shipmentNumber: String? = null
    
    @SerializedName("ScaledWeight")
    var scaledWeight: Double? = null
    
    @SerializedName("RepackNumber")
    var repackNumber: Int? = null
    
    @SerializedName("DunnageWeight")
    var dunnageWeight: Double? = null

    @SerializedName("ArriveStatus")
    var arriveStatus: Int? = null

    @SerializedName("Length")
    var length: Double? = null

    
    @SerializedName("Width")
    var width: Double? = null

    
    @SerializedName("Weight")
    var weight: Double? = null

    
    @SerializedName("Height")
    var height: Double? = null

    
    @SerializedName("Cubic")
    var cubic: Double? = null

    
    @SerializedName("GeneralDescription")
    var generalDescription: String? = null
    
    @SerializedName("IsDangerousGoods")
    var isDangerousGoods: Boolean = false

    @SerializedName("PriorityStatusId")
    var priorityStatusId: Int? = null
    
    @SerializedName("PriorityStatusName")
    var priorityStatusName: String? = null
    
    @SerializedName("CargoNumber")
    var cargoNumber: String? = null
    
    @SerializedName("CargoTypeName")
    var cargoTypeName: String? = null
    
    @SerializedName("ShipmentId")
    var shipmentId: Int? = null
    
    @SerializedName("PriorityRowHighlightColor")
    var priorityRowHighlightColor: String? = null
    
    @SerializedName("VendorName")
    var vendorName: String? = null

    @SerializedName("IsDeleted")
    var isDeleted: Boolean = false

    fun decimal(value: Double?) : String {
        if(value == null) return ""
        return DecimalFormat("#.##").format(value)
    }

}