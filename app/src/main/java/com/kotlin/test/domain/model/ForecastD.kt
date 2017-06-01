package com.kotlin.test.domain.model

/**
 * Created by Administrator on 2017/5/31.
 */
class ForecastD {
    data class ForecastList(val city: String,
                            val country: String,
                            val detailForecast: List<Forecast>
    )

    data class Forecast(val date: String,
                        val description: String,
                        val high: Int,
                        val low: Int)
}