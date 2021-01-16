package com.mwwl.base.bean

/**
 * 返回data的数据是类
 */
open class ApiResponse<T>(
    var status: String,
    var message: String,
    var data: T?
)
