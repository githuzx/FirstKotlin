package com.kotlin.test.origin.other

/**
 * Created by Administrator on 2017/6/19.
 */
class Outer {
    private val bar: Int = 1

    inner class Inner {
        fun foo() = bar
    }
}