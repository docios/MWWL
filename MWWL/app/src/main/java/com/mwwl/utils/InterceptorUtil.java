package com.mwwl.utils;


import com.mwwl.utils.LogUtil;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by zcl on 2018/5/10.
 * Email：1647481399@qq.com
 * Version:1.0
 * Description:请求数据时的日志拦截
 */

public class InterceptorUtil {
    //日志拦截器
    public static HttpLoggingInterceptor LogInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogUtil.e( "log: " + message);

            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);//设置打印数据的级别
    }
}
