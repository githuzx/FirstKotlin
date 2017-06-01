package com.kotlin.test.domain

/**
 * Created by Administrator on 2017/5/31.
 */
interface Command<T> {
    fun execute():T
}