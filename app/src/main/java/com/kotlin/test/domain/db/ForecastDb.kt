package com.kotlin.test.domain.db

import android.database.sqlite.SQLiteDatabase
import com.kotlin.test.domain.datamapper.DbDataMapper
import com.kotlin.test.domain.db.table.CityForecastTable
import com.kotlin.test.domain.db.table.DayForecastTable
import com.kotlin.test.domain.model.CityForecast
import com.kotlin.test.domain.model.DayForecast
import com.kotlin.test.domain.model.ForecastD
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder
import org.jetbrains.anko.db.select

/**
 * Created by Administrator on 2017/6/5.
 */
class ForecastDb(val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance, val dataMapper: DbDataMapper) {

    /**
     * select
     */
    fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {

        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND " +
                "${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipCode.toString(), date.toString())
                .parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME)
                .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt { CityForecast(HashMap(it), dailyForecast) }

        if (city != null) dataMapper.convertToDomain(city) else null
    }

    /**
     * insert
     */
    fun saveForecast(forecast: ForecastD.ForecastList) = forecastDbHelper.use {
        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecast)) {
//            insert(CityForecastTable.NAME, *map.toVarargArray())
//            dailyForecast forEach {
//                insert(DayForecastTable.NAME, *it.map.toVarargArray())
//            }
        }
    }

    /**
     * extensions
     */
    fun <T : Any> SelectQueryBuilder.parseList(
            parser: (Map<String, Any>) -> T): List<T> =
            parseList(object : MapRowParser<T> {
                override fun parseRow(columns: Map<String, Any?>): T {
                    return parser(columns as Map<String, Any>)
                }
            })

    fun <T : Any> SelectQueryBuilder.parseOpt(
            parser: (Map<String, Any>) -> T): T? =
            parseOpt(object : MapRowParser<T> {
                override fun parseRow(columns: Map<String, Any?>): T {
                    return parser(columns as Map<String, Any>)
                }
            })

    fun SQLiteDatabase.clear(tableName:String){
        execSQL("delete from $tableName")
    }

    fun <K, V : Any> MutableMap<K, V?>.toVarargArray():
            Array<out Pair<K, V>> =  map({ Pair(it.key, it.value!!) }).toTypedArray()
}