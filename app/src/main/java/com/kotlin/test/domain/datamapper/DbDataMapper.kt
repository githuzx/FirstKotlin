package com.kotlin.test.domain.datamapper

import com.kotlin.test.domain.model.CityForecast
import com.kotlin.test.domain.model.DayForecast
import com.kotlin.test.domain.model.ForecastD

/**
 * Created by Administrator on 2017/6/5.
 */
class DbDataMapper {
    fun convertToDomain(forecast: CityForecast) = with(forecast) {
        val daily = dailyForecast.map { convertDayToDomain(it) }
//        ForecastD.ForecastList(_id, city, country, daily)
    }

    private fun convertDayToDomain(dayForecast: DayForecast) = with(dayForecast) {
//        ForecastD.Forecast(date, description, high, low, iconUrl)
    }

    fun convertFromDomain(forecast: ForecastD.ForecastList) = with(forecast) {
//        val daily = dailyForecast.map { convertDayFromDomain(id, it) }
//        CityForecast(id, city, country, daily)
    }

    private fun convertDayFromDomain(cityId: Long, forecast: ForecastD.Forecast) =
            with(forecast) {
//                DayForecast(date, description, high, low, iconUrl, cityId)
            }
}