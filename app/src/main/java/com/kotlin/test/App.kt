package com.kotlin.test

import android.app.Application
import kotlin.properties.Delegates

/**
 * Created by Administrator on 2017/5/31.
 */
class App : Application() {

    companion object {
        var instance: App by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}