package com.hugo.fairecast.app.view.bindingAdapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hugo.fairecast.R
import com.hugo.fairecast.app.view.adapters.WeatherNextDaysListAdapter
import com.hugo.fairecast.app.view.states.ForecastInfoState
import com.hugo.fairecast.domain.models.DayOfWeek
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("cityName")
fun setCityName(view: TextView, state: ForecastInfoState) {
    when (state) {
        is ForecastInfoState.Success -> view.text = state.presentation.cityName
        is ForecastInfoState.Empty -> view.text = view.context.getString(R.string.empty_data)
        is ForecastInfoState.Error -> view.text = view.context.getString(R.string.empty_data)
        is ForecastInfoState.Loading -> view.text = view.context.getString(R.string.loading)
    }
}

@BindingAdapter("minTemp")
fun setMinTemp(view: TextView, state: ForecastInfoState) {
    when (state) {
        is ForecastInfoState.Success -> view.text =
            view.context.getString(R.string.low_temp, state.presentation.minTemp)
        is ForecastInfoState.Empty -> view.text = view.context.getString(R.string.empty_data)
        is ForecastInfoState.Error -> view.text = view.context.getString(R.string.empty_data)
        is ForecastInfoState.Loading -> view.text = view.context.getString(R.string.loading)
    }
}

@BindingAdapter("maxTemp")
fun setMaxTemp(view: TextView, state: ForecastInfoState) {
    when (state) {
        is ForecastInfoState.Success -> view.text =
            view.context.getString(R.string.high_temp, state.presentation.maxTemp)
        is ForecastInfoState.Empty -> view.text = view.context.getString(R.string.empty_data)
        is ForecastInfoState.Error -> view.text = view.context.getString(R.string.empty_data)
        is ForecastInfoState.Loading -> view.text = view.context.getString(R.string.loading)
    }
}

@BindingAdapter("temp")
fun setTemp(view: TextView, state: ForecastInfoState) {
    when (state) {
        is ForecastInfoState.Success -> view.text =
            view.context.getString(R.string.temp, state.presentation.theTemp)
        is ForecastInfoState.Empty -> view.text = view.context.getString(R.string.empty_data)
        is ForecastInfoState.Error -> view.text = view.context.getString(R.string.empty_data)
        is ForecastInfoState.Loading -> view.text = view.context.getString(R.string.loading)
    }
}

@BindingAdapter("weatherState")
fun setWeatherState(view: TextView, state: ForecastInfoState) {
    when (state) {
        is ForecastInfoState.Success -> view.text = state.presentation.weatherState
        is ForecastInfoState.Empty -> view.text = view.context.getString(R.string.empty_data)
        is ForecastInfoState.Error -> view.text = view.context.getString(R.string.empty_data)
        is ForecastInfoState.Loading -> view.text = view.context.getString(R.string.loading)
    }
}

@BindingAdapter("errorMsg")
fun setErrorMsg(view: TextView, state: ForecastInfoState) {
    view.text = if (state is ForecastInfoState.Error) state.message else ""
}

@BindingAdapter("stateImg")
fun setWeatherStateImg(view: ImageView, state: ForecastInfoState) {
    if (state is ForecastInfoState.Success)
        Glide.with(view).load(
            view.context.getString(
                R.string.weather_state_img_url,
                state.presentation.weatherStateAbr
            )
        ).into(view)
}

@BindingAdapter("stateImgWithAbbr")
fun setWeatherStateImg(view: ImageView, weatherStateAbbr: String) {
    Glide.with(view).load(
        view.context.getString(
            R.string.weather_state_img_url,
            weatherStateAbbr
        )
    ).into(view)
}

@BindingAdapter("items")
fun setListItems(view: RecyclerView, state: ForecastInfoState) {
    val adapter = WeatherNextDaysListAdapter()
    view.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
    view.adapter = adapter
    when (state) {
        is ForecastInfoState.Success -> {
            adapter.setItems(state.presentation.nextDaysPresentation)
        }
        is ForecastInfoState.Empty -> adapter.setItems(emptyList())
        is ForecastInfoState.Error -> adapter.setItems(emptyList())
        is ForecastInfoState.Loading -> adapter.setItems(emptyList())
    }
}

@BindingAdapter("dateAsDay")
fun setDayFromDate(view: TextView, dateString: String) {
    try {
        val date = SimpleDateFormat("yyyy-MM-DD", Locale.getDefault()).parse(dateString)
        val calendar = Calendar.getInstance()
        date?.let {
            calendar.time = date
            view.text = DayOfWeek.fromDayIndex(calendar.get(Calendar.DAY_OF_WEEK)).day
        }
    }catch (e: Exception) {
        view.text = ""
    }
}