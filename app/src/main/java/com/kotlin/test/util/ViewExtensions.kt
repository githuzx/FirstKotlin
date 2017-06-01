package com.kotlin.test.util

import android.content.Context
import android.view.View

/**
 * Created by Administrator on 2017/6/1.
 */
class ViewExtensions {
    val View.ctx:Context
    get() = context
}