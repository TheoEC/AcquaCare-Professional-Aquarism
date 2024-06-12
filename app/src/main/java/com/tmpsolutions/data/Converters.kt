package com.tmpsolutions.data

import androidx.room.TypeConverter
import java.util.Date

class Converters {
    @TypeConverter
    fun dateToTimestamp(date: Date?) : Long? {
        return date?.time
    }

    @TypeConverter
    fun timestampToDate(timestamp: Long?) : Date? {
        return timestamp?.let {
            Date(it)
        }
    }
}