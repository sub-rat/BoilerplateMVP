package com.subratgyawali.boilerplatemvp.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.view.Gravity
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.valdesekamdem.library.mdtoast.MDToast
import android.graphics.Bitmap
import android.util.Base64
import android.graphics.BitmapFactory
import android.net.NetworkCapabilities
import android.os.Build
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


fun checkNetworkAvailability(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val nw = connectivityManager.activeNetwork ?: return false
    val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
    return when {
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        else -> false
    }
}



fun Fragment.showToast(message: String, type: Int) {
    val toast = com.valdesekamdem.library.mdtoast.MDToast.makeText(context, message, android.widget.Toast.LENGTH_SHORT, type)
    toast.setGravity(android.view.Gravity.BOTTOM, 0, fromDPtoPX(120));
    toast.show()
}

fun Activity.showToast(message: String, type: Int) {
    val toast = MDToast.makeText(this, message, Toast.LENGTH_SHORT, type)
    toast.setGravity(Gravity.BOTTOM, 0, fromDPtoPX(120));
    toast.show()
}

fun Fragment.fromDPtoPX(dp: Int): Int {
    return dp * resources.displayMetrics.density.toInt()
}

fun Activity.fromDPtoPX(dp: Int): Int {
    return dp * resources.displayMetrics.density.toInt()
}

fun EditText.showSoftKeyboard() {
    if (this.requestFocus()) {
        val imm: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager;
        imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT);
    }
}


fun EditText.hideSoftKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, InputMethodManager.HIDE_IMPLICIT_ONLY)
}


fun encodetoBase64(img: File): String {
    val bytes = img.readBytes()
    val encodedString = "data:image/png;base64,"
    return encodedString + Base64.encodeToString(bytes,Base64.NO_WRAP)

//    val baos = ByteArrayOutputStream()
//    bm.compress(Bitmap.CompressFormat.PNG, 50, baos) //bm is the bitmap object
//    val b = baos.toByteArray()
//    val encodedString = "data:image/png;base64,"
//    return encodedString + Base64.encodeToString(b, Base64.DEFAULT)
}


fun saveBitmapToFile(file: File): File? {
    try {

        // BitmapFactory options to downsize the image
        val o = BitmapFactory.Options()
        o.inJustDecodeBounds = true
        o.inSampleSize = 6
        // factor of downsizing the image

        var inputStream = FileInputStream(file)
        //Bitmap selectedBitmap = null;
        BitmapFactory.decodeStream(inputStream, null, o)
        inputStream.close()

        // The new size we want to scale to
        val REQUIRED_SIZE = 75

        // Find the correct scale value. It should be the power of 2.
        var scale = 1
        while (o.outWidth / scale / 2 >= REQUIRED_SIZE && o.outHeight / scale / 2 >= REQUIRED_SIZE) {
            scale *= 2
        }

        val o2 = BitmapFactory.Options()
        o2.inSampleSize = scale
        inputStream = FileInputStream(file)

        val selectedBitmap = BitmapFactory.decodeStream(inputStream, null, o2)
        inputStream.close()

        // here i override the original image file
        file.createNewFile()
        val outputStream = FileOutputStream(file)

        selectedBitmap!!.compress(Bitmap.CompressFormat.PNG, 50, outputStream)

        return file
    } catch (e: Exception) {
        return null
    }

}