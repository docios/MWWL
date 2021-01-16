package com.mwwl.weight.loadCallBack


import android.content.Context
import android.view.View
import com.kingja.loadsir.callback.Callback
import com.mwwl.R


/**
 *
 */

class LoadingCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.layout_loading
    }

    override fun getSuccessVisible(): Boolean {
        return super.getSuccessVisible()
    }

    override fun onReloadEvent(context: Context?, view: View?): Boolean {
        return true
    }
}
