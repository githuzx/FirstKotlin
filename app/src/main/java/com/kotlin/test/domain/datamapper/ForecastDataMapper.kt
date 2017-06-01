package com.kotlin.test.domain.datamapper

import android.icu.text.DateFormat
import com.kotlin.test.domain.model.ForecastD
import com.kotlin.test.domain.bean.ForecastBean
import java.util.*
import com.kotlin.test.domain.model.ForecastD.Forecast as ModelForecast

/**
 * Created by Administrator on 2017/5/31.
 */
public class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastBean.ForecastResult): ForecastD.ForecastList {
        return ForecastD.ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list)) //result list
    }

    private fun convertForecastListToDomain(list: List<ForecastBean.Forecast>):
            List<ForecastD.Forecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: ForecastBean.Forecast): ForecastD.Forecast {
        return ForecastD.Forecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}