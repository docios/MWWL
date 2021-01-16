package com.mwwl.weight.loadCallBack

import com.kingja.loadsir.callback.Callback
import com.mwwl.R


/**
 * 空布局
 */

class EmptyCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.layout_empty
    }

}
