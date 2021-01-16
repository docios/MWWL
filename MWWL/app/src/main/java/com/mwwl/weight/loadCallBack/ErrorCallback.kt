package com.mwwl.weight.loadCallBack

import com.kingja.loadsir.callback.Callback
import com.mwwl.R

//错误布局
class ErrorCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.layout_error
    }
}
