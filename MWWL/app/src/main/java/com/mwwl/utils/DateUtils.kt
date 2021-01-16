package com.mwwl.utils

import java.io.UnsupportedEncodingException
import java.lang.Long
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar
import java.util.regex.Pattern

/**
 * Created by zcl on 2018/4/24.
 * Email：1647481399@qq.com
 * Version:1.0
 * Description:日期的工具类
 */

class DateUtils {


    var dateFormatYMD = "yyyy-MM-dd"
    var dateFormatYMDH = "yyyy-MM-dd HH:mm"
    var dateFormatYMDHM = "yyyy-MM-dd HH:mm:ss"

    /**
     * 比较两个日期的大小，日期格式为yyyy-MM-dd
     *
     * @param str1 the first date
     * @param str2 the second date
     * @return true <br></br>false
     */

    fun isDateOneBigger(str1: String, str2: String,pattern: String): Boolean {
        var isBigger = false
        val sdf = SimpleDateFormat(pattern)
        var dt1: Date? = null
        var dt2: Date? = null
        try {
            dt1 = sdf.parse(str1)
            dt2 = sdf.parse(str2)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        if (dt1!!.time >= dt2!!.time) {
            isBigger = true
        } else if (dt1.time < dt2.time) {
            isBigger = false
        }
        return isBigger
    }

    /**
     * 获取当前系统前后第几天
     */
    fun getTimeOffset(offset: Int): String {
        val dateFormat = SimpleDateFormat(dateFormatYMD)
        val calendar = GregorianCalendar()
        calendar.add(Calendar.DAY_OF_MONTH, offset)
        return dateFormat.format(calendar.time)
    }

    /**
     * 日期回滚
     *
     * @param day
     * @return
     */
    fun getTimeRoll(day: Int): String {
        val sdf = SimpleDateFormat(dateFormatYMD)
        val lastDate = Calendar.getInstance()
        lastDate.roll(Calendar.DAY_OF_YEAR, day)//日期回滚3天
        return sdf.format(lastDate.time)
    }

    /**
     * 日期回滚
     *
     * @param day
     * @return
     */
    fun getHourseRoll(hour: Int): String {
        val sdf = SimpleDateFormat(dateFormatYMDH)
        val lastDate = Calendar.getInstance()
        lastDate.set(Calendar.HOUR_OF_DAY, lastDate.get(Calendar.HOUR_OF_DAY) - hour)//日期回滚3天
        return sdf.format(lastDate.time)
    }


    /**
     * 获取现在时间 yyyy-MM-dd
     *
     * @return
     */
    val nowTime: String
        get() {
            val date = Date()
            val sdf = SimpleDateFormat(dateFormatYMD)
            return sdf.format(date)
        }

    val nowTimeHour: String
        get() {
            val date = Date()
            val sdf = SimpleDateFormat(dateFormatYMDH)
            return sdf.format(date)
        }

    //获取现在时间 yyyy-MM-dd HH:mm:ss
    val nowAccurateTime: String
        get() {
            val date = Date()
            val sdf = SimpleDateFormat(dateFormatYMDHM)
            return sdf.format(date)
        }


    //获取现在时间 yyyy-MM-dd HH:mm:ss
    val ccurateTime: String
        get() {
            val date = Date()
            val sdf = SimpleDateFormat("yyyyMMdd_HHmmss")
            return sdf.format(date)
        }

    /**
     * 蓝牙票据单号
     */
    val blueNumber: String
        get() {
            val date = Date()
            val sdf = SimpleDateFormat("yyyyMMddHHmmss")
            return sdf.format(date)
        }




    //时间转化为时间戳
    fun timeStampYMD(user_time: String): String {
        var timeStamp: String = ""
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val l = sdf.parse(user_time)
        timeStamp = (l.getTime() / 1000).toString()
        return timeStamp
    }
    //时间戳转化成时间-- 传入的是时间戳
    fun timeTOUTC(time: String): String {
        var a = 0L
        if (time.toLong() < 10000000000L) {
            a = time.toLong() * 1000
        } else {
            a = time.toLong()
        }
        val sdf = SimpleDateFormat(dateFormatYMD)
        val format = sdf.format(Date(a))
        return format
    }
    //按照指定时间回滚--*-返回的是时间戳
    fun hourseRoll(time: String, hour: Int): String {
        var newTime = ""
        val sdf = SimpleDateFormat(dateFormatYMDHM)
        val l = sdf.parse(time).time
        val l1 = l / 1000 - hour * 3600
        val str = l1.toString()
        newTime = str.substring(0, 10)
        return newTime
    }


    //按照指定时间回滚--*-返回的是时间
    fun hourseRollTime(time: String, hour: Int): String {
        var newTime = ""
        val sdf = SimpleDateFormat(dateFormatYMDHM)
        val l = sdf.parse(time).time
        val l1 = (l / 1000 - hour * 3600)
        val l2 = l1 * 1000
        val date = Date(l2)
        val simpleDateFormat = SimpleDateFormat(dateFormatYMDHM)
        newTime = simpleDateFormat.format(date)
        return newTime
    }

    //时间戳转化成时间-- 传入的是时间戳
    fun stampToTime(time: String): String {
        var a = 0L
        if (time.toLong() < 10000000000L) {
            a = time.toLong() * 1000
        } else {
            a = time.toLong()
        }
        val sdf = SimpleDateFormat(dateFormatYMDHM)
        val format = sdf.format(Date(a))
        return format
    }


    //指定时间的时间戳--传入的是时间 格式 yyyy-MM-dd HH:mm:ss
    fun timeStamp(user_time: String): String {
        var timeStamp: String = ""
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val l = sdf.parse(user_time)
        val str = l.time.toString()
        timeStamp = str.substring(0, 10)
        return timeStamp
    }


    //获取几天之前的时间
    fun timeOtherDay(day: Int): String {
        val sdf = SimpleDateFormat(dateFormatYMDHM)
        val c = Calendar.getInstance()
        c.add(Calendar.DATE, -day)
        val monday = c.time
        return sdf.format(monday)
    }


    //当前获取时间戳
    fun getTimestamp(): String {
        val l = System.currentTimeMillis() / 1000//获取系统时间的10位的时间戳
        return l.toString()
    }

    /**获取两个时间间隔*/
    fun timeInterval(sj1: String, sj2: String): Boolean {
        var myFormatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        var timnInterval = true;
        var date = myFormatter.parse(sj1);
        var mydate = myFormatter.parse(sj2);
        val l = (date.getTime() - mydate.getTime()) / (1000)
        if (l > 2592000) {
            timnInterval=false
        }
        return timnInterval
    }
}
