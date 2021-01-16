package com.mwwl.utils

import android.util.Log

/**
 * 日志输出工具
 * Created by juanyuan on 15/12/11.
 */
object LogUtil {
            var TAG = "TAG"
    var isDebug: Boolean = true
    @JvmStatic
    fun i(infos: String) {
        if (isDebug) {
            Log.i(TAG, infos)
        }
    }
    @JvmStatic
    fun e(infos: String) {
        if (isDebug) {
            Log.e(TAG, infos)
        }
    }

    fun v(infos: String) {
        if (isDebug) {
            Log.v(TAG, infos)
        }
    }
    @JvmStatic
    fun d(infos: String) {
        if (isDebug) {
            Log.d(TAG, infos)
        }
    }

}
