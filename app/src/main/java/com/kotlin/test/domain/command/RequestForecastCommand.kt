package com.kotlin.test.domain.command

import com.kotlin.test.domain.Command
import com.kotlin.test.domain.datamapper.ForecastDataMapper
import com.kotlin.test.domain.model.ForecastD
import com.kotlin.test.domain.network.ForecastRequest

/**
 * Created by Administrator on 2017/5/31.
 */
class RequestForecastCommand(private val zipCode: String) : Command<ForecastD.ForecastList> {

    override fun execute(): ForecastD.ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}