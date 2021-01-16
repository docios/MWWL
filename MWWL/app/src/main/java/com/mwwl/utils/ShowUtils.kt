package com.mwwl.utils

import android.app.ProgressDialog
import android.content.Context
import android.graphics.drawable.ClipDrawable
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.Window


object ShowUtils {
    private var dialog: ProgressDialog? = null
    fun showLoading(context: Context) {
        dialog?.run {
            if (isShowing) return
        }
        dialog = ProgressDialog(context)
        dialog?.run {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setCanceledOnTouchOutside(false)
            setProgressStyle(ProgressDialog.STYLE_SPINNER)
            setMessage("请求网络中...")
            val d = ClipDrawable(ColorDrawable(SettingUtil.getColor(context)), Gravity.LEFT, ClipDrawable.HORIZONTAL)
            setProgressDrawable(d)
            show()
        }
    }

    fun dismissLoading() {
        dialog?.run {
            if (isShowing) {
                dismiss()
            }
        }
        dialog = null
    }



}
