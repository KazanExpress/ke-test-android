package com.ke_test_app.testapplication.data.Utils

import java.text.SimpleDateFormat
import java.util.*

// Метод получения даты и времени из Date()
fun changeData(date : Date) : String {
    val sdf = SimpleDateFormat("hh:mm:ss dd.MM.yy")
    val currentDate = sdf.format(Date())
    return currentDate
}