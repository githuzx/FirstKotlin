package com.kotlin.test.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.test.R
import com.kotlin.test.domain.model.ForecastD
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list_forecast.view.*

/**
 * Created by Administrator on 2017/5/31.
 */
class ForecastListAdapter(val weekForecast: ForecastD.ForecastList,
                          val itemClick: (ForecastD.Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size()

    class ViewHolder(view: View, val itemClick: (ForecastD.Forecast) -> Unit) :
            RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: ForecastD.Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "${high.toString()}℃"
                itemView.minTemperature.text = "${low.toString()}℃"
                itemView.setOnClickListener { itemClick(forecast) }
            }
        }
    }
}