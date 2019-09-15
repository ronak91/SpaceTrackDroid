package com.spacetrack.app.model

import android.location.Address
import ca.aenv.dcl.model.BaseModel
import com.spacetrack.app.utils.Constants
import com.google.gson.annotations.SerializedName


class Manifest : BaseModel(){
    var localId: Long? = null
    @SerializedName("Id")
    var id: Int = -1

    @SerializedName("ManifestNumber")
    var manifestNumber: String? = null
    @SerializedName("OriginAddress")
    var originAddress: Address? = null
    @SerializedName("OriginAddressId")
    var originAddressId: Int? = null
    @SerializedName("DestinationAddress")
    var destinationAddress: Address? = null
    @SerializedName("DestinationAddressId")
    var destinationAddressId: Int? = null

    @SerializedName("ManifestStatusName")
    var manifestStatusName: String? = null
    @SerializedName("ManifestStatus")
    var manifestStatus: Int? = null

    @SerializedName("ServiceType")
    var serviceType: Int? = null

    @SerializedName("ManifestType")
    var manifestType: Int? = null

    @SerializedName("CarrierId")
    var carrierId: Int? = null


    @SerializedName("CarrierName")
    var carrierName: String? = null


    @SerializedName("SAPManifestNumber")
    var sapManifestNumber: String? = null

    @SerializedName("ClientId")
    var clientId: Int? = null

    @SerializedName("ClientName")
    var clientName: String? = null

    @SerializedName("ManisfestDate")
    var manisfestDate: String? = null

    @SerializedName("TrailerNumber")
    var trailerNumber: String? = null

    @SerializedName("TrailerTypeId")
    var trailerTypeId: Int? = null

    @SerializedName("TrailerConfigurationId")
    var trailerConfigurationId: Int? = null

    @SerializedName("DriverNumber")
    var driverNumber: String? = null

    @SerializedName("WRShipmentNumber")
    var wrShipmentNumber: String? = null


    @SerializedName("CarrierWaybillNumber")
    var carrierWaybillNumber: String? = null

    @SerializedName("FuelLiftNumber")
    var fuelLiftNumber: String? = null

    @SerializedName("ANBOLNumber")
    var anbolNumber: String? = null

    @SerializedName("AirCraftTypeId")
    var airCraftTypeId: Int? = null

    @SerializedName("RegistrationNumber")
    var registrationNumber: String? = null

    @SerializedName("ConfigurationId")
    var configurationId: Int? = null

    @SerializedName("ServiceId")
    var serviceId: Int? = null

    @SerializedName("TrailerTypeName")
    var trailerTypeName: String? = null

    @SerializedName("TrailerConfigurationName")
    var trailerConfigurationName: String? = null

    @SerializedName("AirCraftTypeName")
    var airCraftTypeName: String? = null

    @SerializedName("ConfigurationName")
    var configurationName: String? = null

    @SerializedName("ServiceName")
    var serviceName: String? = null

    @SerializedName("ManifestTypeName")
    var manifestTypeName: String? = null

    @SerializedName("ServiceTypeName")
    var serviceTypeName: String? = null


    @SerializedName("ManifestCargoList")
    var cargoList: List<ManifestCargo>? = ArrayList()

    @SerializedName("RowVersion")
    var rowVersion: String? = null
    var isSynced: Boolean = true


    override fun toString(): String {
        return manifestNumber + ""
    }
}