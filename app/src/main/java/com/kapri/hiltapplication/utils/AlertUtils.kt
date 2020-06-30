package com.kapri.hiltapplication.utils

import android.content.Context
import android.widget.Toast

object AlertUtils {

    private var toast: Toast? = null
    fun showToast(context: Context, error: String) {
        toast?.cancel()
        toast = Toast.makeText(context, error, Toast.LENGTH_SHORT)
        toast?.show()
    }
}