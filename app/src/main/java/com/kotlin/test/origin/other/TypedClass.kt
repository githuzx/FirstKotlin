package com.kotlin.test.origin.other

/**
 * Created by Administrator on 2017/6/19.
 */
class TypedClass<T : Any>(parameter: T) {
    val value: T = parameter
}