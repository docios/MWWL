package com.mwwl.utils

import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class Md5Utils {

    /**
     * 通过MD5加密后，获取app登录的X-Token
     * 加密方式: md5(username + password + 盐 + timeunix)
     */
//    fun loginMd5Key(username: String, password: String,currentTimeStamp : String): String {
//        val key =
//            username.toLowerCase() + password + AppSetting.Encryption + currentTimeStamp
//        val hash: ByteArray
//        try {
//            hash = MessageDigest.getInstance("MD5").digest(key.toByteArray(charset("UTF-8")))
//        } catch (e: NoSuchAlgorithmException) {
//            throw RuntimeException("Huh, MD5 should be supported?", e)
//        } catch (e: UnsupportedEncodingException) {
//            throw RuntimeException("Huh, UTF-8 should be supported?", e)
//        }
//
//        val hex = StringBuilder(hash.size * 2)
//        for (b in hash) {
//            var i: Int = b.toInt() and 0xff//获取低八位有效值
//
//            var toHexString = Integer.toHexString(i)
//
//            if (toHexString.length < 2) {
//                toHexString = "0" + toHexString//如果是一位的话，补0
//            }
//            hex.append(toHexString)
//        }
//        return hex.toString()
//    }







}