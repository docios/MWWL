package com.mwwl.utils

import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tencent.mmkv.MMKV


object CacheUtil {

//    /**
//     * 获取保存的账户信息
//     */
//    fun getUser(): LoginResponse {
//        val kv = MMKV.mmkvWithID("app")
//        val userStr = kv.decodeString("user")
//        return if (TextUtils.isEmpty(userStr)) {
//            LoginResponse(
//                0, "", "", "", 0, ""
//            )
//        } else {
//            Gson().fromJson(userStr, LoginResponse::class.java)
//        }
//    }
//
//    /**
//     * 设置账户信息
//     */
//    fun setUser(userResponse: LoginResponse?) {
//        val kv = MMKV.mmkvWithID("app")
//        if (userResponse == null) {
//            kv.encode("user", "")
//            setIsLogin(false)
//            setJurisdiction(arrayListOf<String>()?.toHashSet())
//        } else {
//            kv.encode("user", Gson().toJson(userResponse))
//            setIsLogin(true)
//        }
//
//    }
//
//    /**
//     * 是否已经登录
//     */
//    fun isLogin(): Boolean {
//        val kv = MMKV.mmkvWithID("app")
//        return kv.decodeBool("login", false)
//    }
//
//    /**
//     * 设置是否已经登录
//     */
//    fun setIsLogin(isLogin: Boolean) {
//        val kv = MMKV.mmkvWithID("app")
//        kv.encode("login", isLogin)
//    }
//
//    //设置用户权限
//    fun setJurisdiction(mutableList: Set<String>?) {
//        val kv = MMKV.mmkvWithID("app")
//        if (mutableList == null) {
//            kv.encode("jurisdiction", "")
//        } else {
//            kv.encode("jurisdiction", mutableList)
//        }
//    }
//
//
//    //获取用户权限
//    fun getJurisdiction(): Set<String> {
//        val kv = MMKV.mmkvWithID("app")
//        return kv.decodeStringSet("jurisdiction")
//    }

//
//    /**
//     * 获取Cookie信息
//     */
//    fun  getCookie(): ""?{
//        val kv = MMKV.mmkvWithID("app")
//        return kv.decodeString("cookie")
//    }
//
//    /**
//     * 保存Cookie信息
//     */
//    fun setCookie(cookie:""){
//        val kv = MMKV.mmkvWithID("app")
//        kv.encode("cookie",cookie)
//    }
//


}