package com.spacetrack.app.utils

import java.text.SimpleDateFormat

object Constants {

    val FORM_TYPE_TR: Int = 1
    val FORM_TYPE_MANIFEST: Int = 2
    val REQUEST_PDF: Int = 1212
    const val ACTIVITY_DAMAGE: Int =363
    const val ACTIVITY_RELEASE_TR: Int =364
    const val ACTIVITY_ARRIVE_TR: Int =365
    const val ACTIVITY_RELEASE_MANIFEST: Int =366
    const val ACTIVITY_ARRIVE_MANIFEST: Int =367

    const val SYNC_REFS: Int = 1
    const val SYNC_DELETE_FILES: Int = 2
    const val SYNC_UPLOAD_FILE: Int = 3
    const val SYNC_RELEASE_TR: Int = 4
    const val SYNC_ARRIVE_TR: Int = 5
    const val SYNC_MANIFEST: Int = 4
    const val SYNC_ARRIVE_MANIFEST: Int = 5

    const val ARRIVE_ARRIVED: Int = 3
    const val ARRIVE_MISSING: Int = 2

    const val TAG = "SpaceTrack"
    const val IMAGE_HELPER_PATH = "1016"
    val SERVER_DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS")
    val BROADCAST_NOTIFICATION_TR: String = STApplication.context.packageName + ".NOTIFICATION_TR"
    val BROADCAST_NOTIFICATION_MANIFEST: String = STApplication.context.packageName + ".NOTIFICATION_MANIFEST"

    const val TYPE_PDF: String ="pdf"
    const val TYPE_IMAGE : String ="jpg"

    const val DATA: String = "data"
    const val DATA_TYPE: String = "type"
    const val DATA_CARGO: String = "dataCargo"
    const val DATA_TR_STATUS: String = "trStatus"
    const val DATA_TR_ID: String="trID"

    const val REQUEST_REFS: Int = 99
    const val REQUEST_CAMERA: Int = 98
    const val REQUEST_GALLERY: Int = 100

    const val PERMISSION_STORAGE: Int = 199
    const val PERMISSION_CAMERA: Int = 198

    const val SERVICE_TIME_OUT = 45000
    const val DEFAULT_MAX_RETRIES = 0

    const val HEADER_AUTHORIZATION = "Authorization"
    const val HEADER_FIREBASE = "UserFirebaseToken"

    const val PREFS_REFERENCE_TYPES = "PrefReferenceTypes"
    const val PREFS_ACCESS_TOKEN = "PrefAccessToken"
    const val PREFS_FIREBASE_TOKEN = "PrefFirebaseToken"
    const val PREFS_IS_USER_LOGGED_IN = "PrefIsUserLoggedIn"
    const val PREFS_USER = "PrefUser"


    const val NOTIFICATION_TITLE = "title"
    const val NOTIFICATION_BODY = "body"
    const val NOTIFICATION_DATA = "data"
    const val NOTIFICATION_CHANNEL = "6"
    const val NOTIFICATION_ACTION = "ca.aenv.dcl.Notification"

    const val STATUS_SCHEDULED = 1
    const val STATUS_IN_TRANSIT = 2
    const val STATUS_ARRIVED = 3

    const val FALSE = 0
    const val TRUE = 1

    object ReferenceType {
        const val TR_REFS: Int = 3
        const val TR_DAMAGE: Int = 4
        const val MF_REFS: Int = 9
        const val MF_DAMAGE: Int = 10
    }


}
