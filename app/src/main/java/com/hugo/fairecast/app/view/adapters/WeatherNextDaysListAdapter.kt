package com.hugo.fairecast.app.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hugo.fairecast.app.presentation.NextDaysForecastPresentation
import com.hugo.fairecast.app.view.viewholders.WeatherNextDaysListViewHolder
import com.hugo.fairecast.databinding.WeatherNextDaysViewHolderLayoutBinding

class WeatherNextDaysListAdapter : RecyclerView.Adapter<WeatherNextDaysListViewHolder>() {

    private val weatherInfos = mutableListOf<NextDaysForecastPresentation>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherNextDaysListViewHolder {
        return WeatherNextDaysListViewHolder(
            WeatherNextDaysViewHolderLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: WeatherNextDaysListViewHolder, position: Int) {
        holder.setData(weatherInfos[position])
    }

    override fun getItemCount() = weatherInfos.size

    @SuppressLint("NotifyDataSetChanged") // In this case, notifyDataSetChanged makes sense
    fun setItems(weatherInfos: List<NextDaysForecastPresentation>) {
        this.weatherInfos.clear()
        this.weatherInfos.addAll(weatherInfos)
        notifyDataSetChanged()
    }
}