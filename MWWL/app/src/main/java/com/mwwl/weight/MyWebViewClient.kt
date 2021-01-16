package com.mwwl.weight

import android.content.Context
import android.os.Build
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.mwwl.utils.LogUtil
import java.io.IOException

class MyWebViewClient(con:Context)  : WebViewClient() {
    var  context:Context?=null
    init {
        context=con
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        view?.loadUrl(request?.url.toString());
        return true;
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldInterceptRequest(
        view: WebView?,
        request: WebResourceRequest?
    ): WebResourceResponse? {
        if (request?.url.toString().contains("jquery")) {
            LogUtil.e("result:${request?.url.toString()}")
            return editResponse();
        }
//                }
        return super.shouldInterceptRequest(view, request);
    }

    private fun editResponse(): WebResourceResponse? {
        try {
            LogUtil.e("加载本地jquery.js")
            return WebResourceResponse(
                "application/x-javascript",
                "utf-8",
                context?.getAssets()?.open("chart.js")
            )
        } catch (e: IOException) {
            e.printStackTrace()
            LogUtil.e("加载本地js错误：" + e.toString())
        }

        //需处理特殊情况
        return null
    }
}