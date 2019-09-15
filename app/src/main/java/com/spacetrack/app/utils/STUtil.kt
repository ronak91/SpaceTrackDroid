package com.spacetrack.app.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Base64
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.spacetrack.app.api.response.FailedList
import com.spacetrack.app.api.response.SyncResponse
import com.google.gson.Gson
import org.json.JSONObject
import java.io.*
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import com.spacetrack.app.R
import com.spacetrack.app.utils.Constants
import com.spacetrack.app.utils.STApplication


object STUtil {

    //Message

    /*
    {"error":"invalid_grant","error_description":"The username or password provided is incorrect."}
  */
    fun convertJsonToErrorResponse(
        response: String?,
        default: String? = STApplication.context.getString(R.string.something_went_wrong)
    ): String? {
        return try {
            val obj = JSONObject(response)
            if (!obj.isNull("Message")) obj["Message"] as String
            else if (!obj.isNull("error_description")) obj["error_description"] as String
            else default
        } catch (e: Exception) {
            default
        }
    }

    fun json(ref: Any?): String? {
        try {
            return Gson().toJson(ref)
        } catch (e: java.lang.Exception) {
        }
        return null
    }


    fun setTheme(view: View, statusColor: String?) {
        try {
            val layers = ContextCompat.getDrawable(STApplication.context,R.drawable.background_dynamic) as LayerDrawable
            if (statusColor == null) {
                view.background = layers
                return
            }
            val drawable = layers.findDrawableByLayerId(R.id.status_background) as GradientDrawable
            drawable.setColor(getColorFromString(statusColor))
            view.background = layers
        } catch (e: Exception) {
            Log.e(Constants.TAG, "STUtil setTheme : ", e)
        }
    }

    private fun getColorFromString(str: String?): Int {
        try {
            return Color.parseColor(str)
        } catch (e: Exception) {
            return Color.WHITE
        }

    }

    fun encodeImage(path: String?): String? {
        try {
            val bm = BitmapFactory.decodeFile(path)
            val baos = ByteArrayOutputStream()
            bm.compress(Bitmap.CompressFormat.JPEG, 100, baos)
            return "data:image/jpeg;base64," + Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT)
        } catch (e: Exception) {
            Log.e(Constants.TAG, "STUtil encodeImage $path : ", e)
            return null
        }
    }


    fun copyFile(srcUri: Uri?, dstFile: File?): Boolean {
        if (dstFile == null || srcUri == null) return false
        var inputStream: InputStream? = null
        var outputStream: FileOutputStream? = null
        try {
            inputStream = (STApplication.context.contentResolver.openInputStream(srcUri) ?: return false)
            outputStream = FileOutputStream(dstFile)

            // Transfer bytes from in to out
            val buf = ByteArray(1024)
            var len: Int
            do {
                len = inputStream.read(buf)
                if (len <= 0) break
                outputStream.write(buf, 0, len)
            } while (true)
            return true
        } catch (e: FileNotFoundException) {
            return false
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        } finally {
            inputStream?.close()
            outputStream?.close()
        }
    }

    fun getFileName(uri: Uri?): String? {
        var result: String? = null;
        if (uri == null) return result
        if (uri.scheme == "content") {
            val cursor = STApplication.context.contentResolver.query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor?.close()
            }
        }
        if (result == null) {
            try {
                val file = File(uri.path)
                result = file.name
                Log.d(Constants.TAG, "STUtil getFileName : second $result")
            } catch (e: Exception) {
            }
        }
        if (result == null) {
            result = uri.path;
            val cut = result?.lastIndexOf('/') ?: -1
            if (cut != -1) {
                result = result?.substring(cut + 1);
            }
        }

        return result;
    }



    fun generateFilePath(extension: String = "jpg",folder: String = "others"): File? {
        var directory: File? = null
        val baseDir = File(STApplication.context.filesDir, "uploads")
        if (baseDir.exists() || baseDir.mkdirs()) {
            directory = File(baseDir.absolutePath + "/files/$folder")
        }

        return if (directory != null && (directory.exists() || directory.mkdirs())) {
            File(directory.toString() + "/image_" + System.currentTimeMillis() + "." + extension)
        } else null
    }


    fun syncFailedList(response: SyncResponse?): FailedList {
        val data = FailedList()
        for(item in response?.dataList ?: ArrayList()){
            item.id?.let { data.idList.add(it) }
            item.uuid?.let { data.guidList.add(it) }
        }
        return data
    }

    fun deleteFile(localFilePath: String?) {
        if (localFilePath != null) {
            val file = File(localFilePath)
            if (file.exists()) file.delete()
        }
    }

    fun scaleExpand(v: View) {
        val anim = ScaleAnimation(
            0f, 1f, // Start and end values for the X axis scaling
            0f, 1f, // Start and end values for the Y axis scaling
            Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
            Animation.RELATIVE_TO_SELF, 0.5f
        ) // Pivot point of Y scaling
        anim.fillAfter = true // Needed to keep the result of the animation
        anim.duration = 300
        v.startAnimation(anim)
    }
    fun scaleCollapse(v: View) {
        val anim = ScaleAnimation(
            1f, 0f, // Start and end values for the X axis scaling
            1f, 0f, // Start and end values for the Y axis scaling
            Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
            Animation.RELATIVE_TO_SELF, 0.5f
        ) // Pivot point of Y scaling
        anim.fillAfter = true // Needed to keep the result of the animation
        anim.duration = 300
        v.startAnimation(anim)
    }
}