package com.mwwl.utils

import android.app.ProgressDialog
import android.content.Context
import android.graphics.drawable.ClipDrawable
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.view.Gravity
import android.view.Window
import android.widget.Toast


object ShowUtils {
    private var dialog: ProgressDialog? = null
    private var toast: Toast? = null
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

    /**
     * 在屏幕底部吐司 默认
     */
    fun showToast(context: Context, arg: String) {
        if (!TextUtils.isEmpty(arg)) {
            toast?.cancel()
            toast = Toast.makeText(context.applicationContext, arg, Toast.LENGTH_SHORT).apply {
                show()
            }
        }

    }

}
