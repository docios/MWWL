package com.mwwl.utils

import android.content.Context
import com.afollestad.materialdialogs.MaterialDialog

class MaterialDialogUtils(context: Context) {

    var mContext: Context? = null
    var materialDialog: MaterialDialog? = null

    init {
        this.mContext = context

    }


    fun show(title: String? = "温馨提示", message: String, positive: String? = "确定", negative: String? = "取消",   positiveFunction:() -> Unit) {
        if (materialDialog == null) {
            materialDialog = MaterialDialog(mContext!!)
        }
        materialDialog!!.show {
            title(text = "${title}")
            message(text = "${message}")
            cancelable(false)
            positiveButton(text = "${positive}") {
                positiveFunction()
            }
            negativeButton(text = "${negative}")
        }
    }

//    fun show(title: String? = "温馨提示", message: String, positive: String? = "确定", negative: String? = "取消") {
//        //,   positiveFunction:() -> Unit,negativeFunction:() -> Unit
//        if (materialDialog == null) {
//            materialDialog = MaterialDialog(mContext!!)
//        }
//        materialDialog!!.show {
//            title(text = "${title}")
//            message(text = "${message}")
//            cancelable(false)
//            positiveButton(text = "${positive}") {
//            }
//            negativeButton(text = "${negative}"){
//            }
//        }
//    }
}