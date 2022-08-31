package com.hugo.fairecast.domain.models

import java.lang.Exception

enum class DayOfWeek(val day: String) {
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday");

    companion object {
        fun fromDayIndex(dayOfWeekIndex: Int): DayOfWeek {
            return when(dayOfWeekIndex) {
                1-> SUNDAY
                2-> MONDAY
                3-> TUESDAY
                4-> WEDNESDAY
                5-> THURSDAY
                6-> FRIDAY
                7-> SATURDAY
                else -> throw Exception("Not a day of week")
            }
        }
    }
}