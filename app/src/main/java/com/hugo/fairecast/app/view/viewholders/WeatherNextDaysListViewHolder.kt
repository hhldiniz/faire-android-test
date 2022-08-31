package com.hugo.fairecast.app.view.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.hugo.fairecast.app.presentation.NextDaysForecastPresentation
import com.hugo.fairecast.databinding.WeatherNextDaysViewHolderLayoutBinding

class WeatherNextDaysListViewHolder(private val binding: WeatherNextDaysViewHolderLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun setData(nextDaysForecastPresentation: NextDaysForecastPresentation) {
        binding.nextDaysForecastPresentation = nextDaysForecastPresentation
        binding.executePendingBindings()
    }
}