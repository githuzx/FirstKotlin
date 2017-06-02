package com.kotlin.test.domain.network

import android.util.Log
import com.google.gson.Gson
import com.kotlin.test.domain.bean.ForecastBean
import java.net.URL

/**
 * Created by Administrator on 2017/5/31.
 */
class ForecastRequest(val zipCode: String) {
    companion object {
        //[kəmˈpæniən]
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${URL}&APPID=${APP_ID}&q="
    }


    fun execute(): ForecastBean.ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()

        Log.e("------", "-------")
        Log.e("------", "-------")
        Log.e("jsonStr", forecastJsonStr)
        return Gson().fromJson(forecastJsonStr, ForecastBean.ForecastResult::class.java)
    }
}