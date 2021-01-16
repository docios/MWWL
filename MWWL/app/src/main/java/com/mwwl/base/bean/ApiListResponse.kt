package com.mwwl.base.bean

/**
 * data 返回的集合
 */
class ApiListResponse<T>(
    var status: String,
    var message: String,
    var data: MutableList<T>?
)

