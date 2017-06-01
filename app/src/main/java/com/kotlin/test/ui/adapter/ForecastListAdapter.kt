package com.kotlin.test.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.test.R
import com.kotlin.test.domain.model.ForecastD
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

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
        private val item_icon: ImageView
        private val item_date: TextView
        private val item_description: TextView
        private val item_maxTemperature: TextView
        private val item_minTemperature: TextView

        init {
            item_icon = view.find(R.id.item_icon)
            item_date = view.find(R.id.item_date)
            item_description = view.find(R.id.item_description)
            item_maxTemperature = view.find(R.id.item_maxTemperature)
            item_minTemperature = view.find(R.id.item_minTemperature)
        }

        fun bindForecast(forecast: ForecastD.Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(item_icon)
                item_date.text = date
                item_description.text = description
                item_maxTemperature.text = "${high.toString()}℃"
                item_minTemperature.text = "${low.toString()}℃"
                itemView.setOnClickListener { itemClick(forecast) }
            }
        }
    }
}